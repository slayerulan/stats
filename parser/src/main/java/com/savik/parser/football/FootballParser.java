package com.savik.parser.football;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

import com.savik.football.model.Championship;
import com.savik.football.model.Match;
import com.savik.football.model.Season;
import com.savik.football.model.Team;
import com.savik.football.repository.MatchRepository;
import com.savik.football.repository.TeamRepository;
import com.savik.parser.Downloader;
import com.savik.parser.LeagueParser;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Savushkin Yauheni
 * @since 12.04.2017
 */
@Service
public class FootballParser {

    @Autowired
    MatchRepository matchRepository;

    @Autowired
    MatchParser matchParser;

    @Autowired
    LeagueParser leagueParser;

    public void parse() {

       // List<String> allMatches = leagueParser.findAllMatches("http://www.myscore.ru/football/spain/laliga/results/");

     //   for (String matchId : allMatches) {
            try {
                if(matchRepository.findByMyscoreCode("0pzb3GHT") == null) {
                    Match match = matchParser.parse("0pzb3GHT", Championship.LA, Season.S2016);
                    matchRepository.save(match);
                    Thread.sleep(1000);
                }
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
;
   //     }

    }
}
