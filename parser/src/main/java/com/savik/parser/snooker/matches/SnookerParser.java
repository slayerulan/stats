package com.savik.parser.snooker.matches;

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
        double maxDrawdawn = 0;
        List<SnookerMatch> all = snookerMatchRepository.findBySeason(Season.S2016);
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
                    failedCounter = 0;
                } else if (favorite == Who.GUEST && match.getWinner() == Winner.HOME) {
                    value += bookieStats.getHomeRate() - 1;
                    failedCounter = 0;
                } else {
                    value -= 1;
                    failedCounter++;
                }
                if (failedCounter > maxFailedStreak) {
                    maxFailedStreak = failedCounter;
                }
            }
        }
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
}
