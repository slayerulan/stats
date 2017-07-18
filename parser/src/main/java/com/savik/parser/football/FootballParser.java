package com.savik.parser.football;

import java.util.List;

import com.savik.football.model.FootballChampionship;
import com.savik.football.model.FootballMatch;
import com.savik.football.model.Season;
import com.savik.football.repository.FootballMatchRepository;
import com.savik.parser.LeagueParser;
import lombok.extern.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Savushkin Yauheni
 * @since 12.04.2017
 */
@Service
@Slf4j
public class FootballParser {

    @Autowired
    FootballMatchRepository footballMatchRepository;

    @Autowired
    MatchParser matchParser;

    @Autowired
    LeagueParser leagueParser;

    public void parse() {

        /*
        bcLlhGkn - кривой матч без статы по таймам
        v9xniz5h - есть матч и 2 тайм
        * */
/*        try {
     //       if(matchRepository.findByMyscoreCode("v9xniz5h") == null) {
                FootballMatch match = matchParser.parse("v9xniz5h", Championship.LA, Season.S2016);
                matchRepository.save(match);
                Thread.sleep(1000);
 //           }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }*/

        List<String> allMatches = leagueParser.findAllMatches("http://www.myscore.ru/football/spain/laliga/results/");
        for (String matchId : allMatches) {
            try {
                if (footballMatchRepository.findByMyscoreCode(matchId) == null) {
                    FootballMatch match = matchParser.parse(matchId, FootballChampionship.LA, Season.S2016);
                    footballMatchRepository.save(match);
                    log.debug("match saved = {}", match);
                    Thread.sleep(1000);
                }
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }

    }
}
