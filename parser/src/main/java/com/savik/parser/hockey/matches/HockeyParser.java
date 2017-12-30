package com.savik.parser.hockey.matches;

import com.savik.Season;
import com.savik.hockey.model.HockeyChampionship;
import com.savik.hockey.model.HockeyMatch;
import com.savik.hockey.repository.HockeyMatchRepository;
import com.savik.parser.LeagueParser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;


@Service
@Slf4j
public class HockeyParser {

    @Autowired
    HockeyMatchRepository hockeyMatchRepository;

    @Autowired
    HockeySingleMatchParser matchParser;

    @Autowired
    LeagueParser leagueParser;

    @AllArgsConstructor
    @Getter
    private class Entity {
        String url;
        HockeyChampionship hockeyChampionship;
        Season season;
    }

    public void parse() {

        List<Entity> entities = Arrays.asList(
                new Entity("https://www.myscore.com.ua/khl/results/", HockeyChampionship.KHL, Season.S2017),
                new Entity("https://www.myscore.com.ua/hockey/usa/nhl/results/", HockeyChampionship.NHL, Season.S2017),
                new Entity("https://www.myscore.com.ua/hockey/czech-republic/extraliga/results/", HockeyChampionship.EXTRA, Season.S2017),
                new Entity("https://www.myscore.com.ua/hockey/germany/del/results/", HockeyChampionship.DEL, Season.S2017),
                new Entity("https://www.myscore.com.ua/hockey/sweden/shl/results/", HockeyChampionship.SHL, Season.S2017)
        );

        /*
        KvlMqOL3 - с овертаймом и буллитами
        * */
       /* try {
            HockeyMatch match = matchParser.parse("SWXVJTjN", HockeyChampionship.NHL, Season.S2017);
            hockeyMatchRepository.save(match);
            log.debug("match saved = {}", match);
            Thread.sleep(1000);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }*/

        for (Entity entity : entities) {
            List<String> allMatches = leagueParser.findAllMatches(entity.getUrl());
            for (String matchId : allMatches) {
                try {
                    if (hockeyMatchRepository.findByMyscoreCode(matchId) == null) {
                        HockeyMatch match = matchParser.parse(matchId, entity.getHockeyChampionship(), entity.getSeason());
                        hockeyMatchRepository.save(match);
                        log.debug("match saved = {}", match);
                        Thread.sleep(1000);
                    } else {
                        System.out.println("parsed = " + matchId);
                    }
                } catch (Exception ex) {
                    System.out.println("myscore code = " + matchId);
                    System.out.println(ex.getStackTrace().toString());
                    //throw new RuntimeException(ex);
                }
            }
        }


    }
}
