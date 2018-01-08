package com.savik.parser.matches.myscore.snooker;

import com.savik.Season;
import com.savik.Who;
import com.savik.Winner;
import com.savik.parser.LeagueParser;
import com.savik.snooker.model.SnookerBookieStats;
import com.savik.snooker.model.SnookerChampionship;
import com.savik.snooker.model.SnookerMatch;
import com.savik.snooker.repository.SnookerMatchRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
@Slf4j
public class SnookerParser {

    @Autowired
    SnookerMatchRepository snookerMatchRepository;

    @Autowired
    SnookerSingleMatchParser matchParser;

    @Autowired
    LeagueParser leagueParser;

    @AllArgsConstructor
    @Getter
    private class Entity {
        String url;
        SnookerChampionship snookerChampionship;
        Season season;
    }

    public void parse() {

        List<Entity> entities = Arrays.asList(
                //new Entity("https://www.myscore.com.ua/snooker/scotland/scottish-open/results/", SnookerChampionship.SCOTTISH_OPEN, Season.S2017),
                new Entity("https://www.myscore.com.ua/snooker/scotland/scottish-open-2016/results/", SnookerChampionship.SCOTTISH_OPEN, Season.S2016)
        );

        double value = 0;
        int maxFailedStreak = 0;
        int failedCounter = 0;
        int successCounter = 0;
        double maxDrawdawn = 0;
        List<SnookerMatch> all = snookerMatchRepository.findBySeason(Season.S2017);
        List<SnookerMatch> tempFailedMatches = new ArrayList<>();
        List<SnookerMatch> failedMatches = new ArrayList<>();
        List<Integer> streaks = new ArrayList<>();
        List<Entry> successCoeffs = new ArrayList<>();
        for (SnookerMatch match : all) {
            SnookerBookieStats bookieStats = match.getBookieStats();
            if (bookieStats != null) {
                Who favorite = bookieStats.getFavorite();
                if (favorite == Who.UNKNOWN) {
                    continue;
                    //throw new RuntimeException("aaaaaa");
                }
                if (favorite == Who.HOME && match.getWinner() == Winner.GUEST) {
                    value += bookieStats.getGuestRate() - 1;
                    streaks.add(failedCounter);
                    failedCounter = 0;
                    successCounter++;
                    tempFailedMatches = new ArrayList<>();
                    successCoeffs.add(new Entry(match.getHomeTeam().getName(), match.getGuestTeam().getName(), match.getDate(), bookieStats.getGuestRate()));
                } else if (favorite == Who.GUEST && match.getWinner() == Winner.HOME) {
                    value += bookieStats.getHomeRate() - 1;
                    streaks.add(failedCounter);
                    failedCounter = 0;
                    successCounter++;
                    tempFailedMatches = new ArrayList<>();
                    successCoeffs.add(new Entry(match.getHomeTeam().getName(), match.getGuestTeam().getName(), match.getDate(), bookieStats.getHomeRate()));
                } else {
                    value -= 1;
                    failedCounter++;
                    tempFailedMatches.add(match);
                }
                if (failedCounter > maxFailedStreak) {
                    maxFailedStreak = failedCounter;
                    failedMatches = new ArrayList<>(tempFailedMatches);
                }
            }
        }
        streaks.add(failedCounter);
        System.out.println("value = " + value);
        System.out.println("maxFailedStreak = " + maxFailedStreak);

        /*for (Entity entity : entities) {
            List<String> allMatches = leagueParser.findAllMatches(entity.getUrl());
            for (String matchId : allMatches) {
                try {
                    if (snookerMatchRepository.findByMyscoreCode(matchId) == null) {
                        SnookerMatch match = matchParser.parse(matchId, entity.getSnookerChampionship(), entity.getSeason());
                        if(match == null) {
                            continue;
                        }
                        snookerMatchRepository.save(match);
                        log.debug("match saved = {}", match);
                        Thread.sleep(1000);
                    } else {
                        System.out.println("parsed = " + matchId);
                        break;
                    }
                } catch (Exception ex) {
                    System.out.println("myscore code = " + matchId);
                    System.out.println(ex.getStackTrace().toString());
                    throw new RuntimeException(ex);
                }
            }
        }*/


    }

    @AllArgsConstructor
    @Getter
    static class Entry {
        String home;
        String guest;
        LocalDateTime time;
        Double coeff;

        @Override
        public String toString() {
            return "{" +
                    "home='" + home + '\'' +
                    ", guest='" + guest + '\'' +
                    ", time=" + time +
                    ", coeff=" + coeff +
                    '}';
        }
    }
}
