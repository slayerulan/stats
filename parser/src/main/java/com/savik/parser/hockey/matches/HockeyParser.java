package com.savik.parser.hockey.matches;

import com.savik.Season;
import com.savik.hockey.model.HockeyChampionship;
import com.savik.hockey.model.HockeyMatch;
import com.savik.hockey.repository.HockeyMatchRepository;
import com.savik.parser.LeagueParser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void parse() {


        /*
        KvlMqOL3 - с овертаймом и буллитами
        * */
       /* try {
            HockeyMatch match = matchParser.parse("KvlMqOL3", HockeyChampionship.NHL, Season.S2016);
            hockeyMatchRepository.save(match);
            log.debug("match saved = {}", match);
            Thread.sleep(1000);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }*/

        List<String> allMatches = leagueParser.findAllMatches("https://www.myscore.com.ua/khl/results/");
        for (String matchId : allMatches) {
            try {
                if (hockeyMatchRepository.findByMyscoreCode(matchId) == null) {
                    HockeyMatch match = matchParser.parse(matchId, HockeyChampionship.KHL, Season.S2017);
                    hockeyMatchRepository.save(match);
                    log.debug("match saved = {}", match);
                    Thread.sleep(1000);
                } else {
                    System.out.println("parsed = " + matchId);
                }
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }

    }
}
