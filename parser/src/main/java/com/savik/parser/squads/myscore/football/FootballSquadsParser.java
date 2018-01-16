package com.savik.parser.squads.myscore.football;

import com.savik.football.model.FootballFutureMatch;
import com.savik.football.model.FootballSquadPlayeerSeasonStats;
import com.savik.football.model.FootballTeamSquad;
import com.savik.football.repository.FootballFutureMatchRepository;
import com.savik.football.repository.FootballTeamSquadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import static com.savik.football.specifications.FootballTeamSquadSpec.hasTeam;

/**
 * @author Savushkin Yauheni
 * @since 12.04.2017
 */
@Service
public class FootballSquadsParser {

    @Autowired
    FootballFutureMatchRepository matchRepository;

    @Autowired
    FootballTeamSquadParser footballTeamSquadParser;


    @Autowired
    FootballTeamSquadRepository footballTeamSquadRepository;


    public void parse() {

        FootballFutureMatch byMyscoreCode = matchRepository.findByMyscoreCode("GCtcphcc");
        footballTeamSquadParser.parse(byMyscoreCode);


        FootballTeamSquad homeSquadInfo = footballTeamSquadRepository.findOne(hasTeam(byMyscoreCode.getHomeTeam()));
        FootballTeamSquad guestSquadInfo = footballTeamSquadRepository.findOne(hasTeam(byMyscoreCode.getGuestTeam()));

        FutureMatchSquads futureMatchSquads = footballTeamSquadParser.parseTest(byMyscoreCode);

        System.out.println("\n\nhome line ups");
        test(homeSquadInfo, futureMatchSquads.getHomeLineUpPlayers());

        System.out.println("\n\nhome substitutions");
        test(homeSquadInfo, futureMatchSquads.getHomeSubstitutions());

        System.out.println("\n\nguest line ups");
        test(guestSquadInfo, futureMatchSquads.getGuestLineUpPlayers());

        System.out.println("\n\nguest substitutions");
        test(guestSquadInfo, futureMatchSquads.getGuestSubstitutions());


        String a = "";


/*
        List<FootballFutureMatch> matches = matchRepository.findAll();
        for (FootballFutureMatch match : matches) {
            footballTeamSquadParser.parse(match);
        }*/

    }

    private void test(FootballTeamSquad teamSquad, Set<FutureMatchSquadPlayer> futureMatchPlayers) {
        /*List<FutureMatchSquadPlayer> lineUpPlayers = */
        Set<FootballSquadPlayeerSeasonStats> squadPlayersStats = teamSquad.getSquadPlayers();
        List<FootballSquadPlayeerSeasonStats> futureSquadStats = new ArrayList<>();

        for (FutureMatchSquadPlayer futureMatchSquadPlayer : futureMatchPlayers) {
            FootballSquadPlayeerSeasonStats playeerSeasonStats = getStatsByPlayer(squadPlayersStats, futureMatchSquadPlayer);
            if(playeerSeasonStats == null) {
                continue;
            }
            futureSquadStats.add(playeerSeasonStats);
        }

        List<FootballSquadPlayeerSeasonStats> top5TeamYCardsPlayers = squadPlayersStats.stream()
                .filter(st -> st.getGamesPlayed() > 5 && !st.getIsInjured() && !st.getIsSuspended())
                .sorted(Comparator.comparing(FootballSquadPlayeerSeasonStats::ycAverage).reversed())
                .limit(5)
                .collect(Collectors.toList());

        List<FootballSquadPlayeerSeasonStats> fromTop5 = top5TeamYCardsPlayers.stream().filter(p -> futureSquadStats.contains(p)).collect(Collectors.toList());

        System.out.println("n of top 5 yc players = " + fromTop5.size() + " (" + fromTop5.toString() + ") players");
        System.out.println("average yc/gms from top 5 yc players = " + fromTop5.stream().mapToDouble(st -> st.ycAverage()).average().orElse(0));
        System.out.println("average match squad without from top 5 yc/gms  = " + futureSquadStats.stream()
                .filter(st -> !fromTop5.contains(st))
                .mapToDouble(st -> st.ycAverage()).average().getAsDouble());
        System.out.println("average match squad yc/gms  = " + futureSquadStats.stream().mapToDouble(st -> st.ycAverage()).average().getAsDouble());
        System.out.println("less 5 games played = " + futureSquadStats.stream().filter(st -> st.getGamesPlayed() <= 5).count() + " players");

        String a = "";
    }

    FootballSquadPlayeerSeasonStats getStatsByPlayer(Set<FootballSquadPlayeerSeasonStats> squadPlayersStats, FutureMatchSquadPlayer player) {
        Optional<FootballSquadPlayeerSeasonStats> playerStats = squadPlayersStats.stream()
                .filter(st -> st.getPlayer().getMyscoreCode().equals(player.getMyscoreCode())).findFirst();
        if(!playerStats.isPresent()) {
            System.out.println("strange, player not found = " + player);
            return null;
        }
        return playerStats.get();

    }


}
