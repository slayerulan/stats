package com.savik.parser.matches.myscore.football;

import com.savik.Season;
import com.savik.football.model.FootballChampionship;
import com.savik.football.model.FootballMatch;
import com.savik.football.repository.FootballMatchRepository;
import com.savik.parser.LeagueParser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

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

    @AllArgsConstructor
    @Getter
    private class Entity {
        String url;
        FootballChampionship footballChampionship;
        Season season;
    }

    public void parse() {

        List<Entity> entities = Arrays.asList(
                new Entity("http://www.myscore.ru/football/spain/laliga/results/", FootballChampionship.LA, Season.S2017),
                new Entity("https://www.myscore.com.ua/football/england/premier-league/results/", FootballChampionship.ENGLAND_PREMIER, Season.S2017),
                new Entity("https://www.myscore.com.ua/football/germany/bundesliga/results/", FootballChampionship.BUNDESLIGA, Season.S2017),
                new Entity("https://www.myscore.com.ua/football/france/ligue-1/results/", FootballChampionship.FRANCE_1, Season.S2017),
                new Entity("https://www.myscore.com.ua/football/netherlands/eerste-divisie/results/", FootballChampionship.HOLLAND_1, Season.S2017),
                new Entity("https://www.myscore.com.ua/football/netherlands/eredivisie/results/", FootballChampionship.HOLLAND_EREDIVISIE, Season.S2017),
                new Entity("https://www.myscore.com.ua/football/australia/a-league/results/", FootballChampionship.AUSTRALIA_A, Season.S2017),
                new Entity("https://www.myscore.com.ua/football/portugal/primeira-liga/results/", FootballChampionship.PORTUGAL_PREMIER, Season.S2017),
                new Entity("https://www.myscore.com.ua/football/india/isl/results/", FootballChampionship.INDIA_SUPERLIGA, Season.S2017)
        );


        for (FootballParser.Entity entity : entities) {
            List<String> allMatches = leagueParser.findAllMatches(entity.getUrl());
            for (String matchId : allMatches) {
                try {
                    if (footballMatchRepository.findByMyscoreCode(matchId) == null) {
                        FootballMatch match = matchParser.parse(matchId, entity.getFootballChampionship(), entity.getSeason());
                        footballMatchRepository.save(match);
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
        }
    }
}
