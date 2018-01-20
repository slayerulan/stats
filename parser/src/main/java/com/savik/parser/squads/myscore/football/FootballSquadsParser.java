package com.savik.parser.squads.myscore.football;

import com.savik.football.model.*;
import com.savik.football.repository.FootballFutureMatchInfoRepository;
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

    @Autowired
    FootballFutureMatchInfoRepository footballFutureMatchInfoRepository;


    public void parse() {

        String myscoreCode = "fe9elyY3";
        FootballFutureMatch byMyscoreCode = matchRepository.findByMyscoreCode(myscoreCode);
        footballTeamSquadParser.parse(byMyscoreCode);


        FootballTeamSquad homeSquadInfo = footballTeamSquadRepository.findOne(hasTeam(byMyscoreCode.getHomeTeam()));
        FootballTeamSquad guestSquadInfo = footballTeamSquadRepository.findOne(hasTeam(byMyscoreCode.getGuestTeam()));

        FutureMatchSquads futureMatchSquads = footballTeamSquadParser.parseFutureMatchSquads(byMyscoreCode);


        System.out.println("\n\nhome line ups");
        test(homeSquadInfo, futureMatchSquads.getHomeLineUpPlayers());

        System.out.println("\n\nhome substitutions");
        test(homeSquadInfo, futureMatchSquads.getHomeSubstitutions());

        System.out.println("\n\nguest line ups");
        test(guestSquadInfo, futureMatchSquads.getGuestLineUpPlayers());

        System.out.println("\n\nguest substitutions");
        test(guestSquadInfo, futureMatchSquads.getGuestSubstitutions());

/*        List<FootballFutureMatch> matches = matchRepository.findAll();

        parseLeague(matches.stream().filter(m -> m.getChampionship() == FootballChampionship.FRANCE_1).collect(Collectors.toList()));
        parseLeague(matches.stream().filter(m -> m.getChampionship() == FootballChampionship.BUNDESLIGA).collect(Collectors.toList()));
        parseLeague(matches.stream().filter(m -> m.getChampionship() == FootballChampionship.LA).collect(Collectors.toList()));
        parseLeague(matches.stream().filter(m -> m.getChampionship() == FootballChampionship.PORTUGAL_PREMIER).collect(Collectors.toList()));*/


    }

    private void parseLeague(List<FootballFutureMatch> footballFutureMatches) {

        for (FootballFutureMatch match : footballFutureMatches) {
            footballTeamSquadParser.parse(match);

            FootballTeamSquad homeSquadInfo = footballTeamSquadRepository.findOne(hasTeam(match.getHomeTeam()));
            FootballTeamSquad guestSquadInfo = footballTeamSquadRepository.findOne(hasTeam(match.getGuestTeam()));

            FutureMatchSquads futureMatchSquads = footballTeamSquadParser.parseFutureMatchSquads(match);

            if(futureMatchSquads == null) {
                System.out.println("match doesn't have squads = " + match.getMyscoreCode());
                continue;
            }

            FootballFutureMatchSquadPart homeLineUps = new FootballFutureMatchSquadPart(
                    test2(homeSquadInfo, futureMatchSquads.getHomeLineUpPlayers())
            );

            FootballFutureMatchSquadPart homeSubs = new FootballFutureMatchSquadPart(
                    test2(homeSquadInfo, futureMatchSquads.getHomeSubstitutions())
            );

            FootballFutureMatchSquad homeTeamInfo = new FootballFutureMatchSquad(
                    homeLineUps, homeSubs

            );

            FootballFutureMatchSquadPart guestLineUps = new FootballFutureMatchSquadPart(
                    test2(guestSquadInfo, futureMatchSquads.getGuestLineUpPlayers())
            );

            FootballFutureMatchSquadPart guestSubs = new FootballFutureMatchSquadPart(
                    test2(guestSquadInfo, futureMatchSquads.getGuestSubstitutions())
            );

            FootballFutureMatchSquad guestTeamInfo = new FootballFutureMatchSquad(
                    guestLineUps, guestSubs
            );

            FootballFutureMatchInfo footballFutureMatchInfo = new FootballFutureMatchInfo(
                    match.getMyscoreCode(),
                    homeTeamInfo,
                    guestTeamInfo
            );

            footballFutureMatchInfoRepository.deleteByMyscoreCode(match.getMyscoreCode());
            footballFutureMatchInfoRepository.save(footballFutureMatchInfo);
        }

    }

    private Set<FootballSquadPlayerSeasonStats> test2(FootballTeamSquad teamSquad, Set<FutureMatchSquadPlayer> futureMatchPlayers) {
        Set<FootballSquadPlayerSeasonStats> squadPlayersStats = teamSquad.getSquadPlayers();
        Set<FootballSquadPlayerSeasonStats> futureSquadStats = new HashSet<>();

        for (FutureMatchSquadPlayer futureMatchSquadPlayer : futureMatchPlayers) {
            FootballSquadPlayerSeasonStats playeerSeasonStats = getStatsByPlayer(squadPlayersStats, futureMatchSquadPlayer);
            if (playeerSeasonStats == null) {
                continue;
            }
            futureSquadStats.add(playeerSeasonStats);
        }

        return futureSquadStats;
    }

    private void test(FootballTeamSquad teamSquad, Set<FutureMatchSquadPlayer> futureMatchPlayers) {
        Set<FootballSquadPlayerSeasonStats> squadPlayersStats = teamSquad.getSquadPlayers();
        List<FootballSquadPlayerSeasonStats> futureSquadStats = new ArrayList<>();

        for (FutureMatchSquadPlayer futureMatchSquadPlayer : futureMatchPlayers) {
            FootballSquadPlayerSeasonStats playeerSeasonStats = getStatsByPlayer(squadPlayersStats, futureMatchSquadPlayer);
            if (playeerSeasonStats == null) {
                continue;
            }
            futureSquadStats.add(playeerSeasonStats);
        }

        List<FootballSquadPlayerSeasonStats> top5TeamYCardsPlayers = squadPlayersStats.stream()
                .filter(st -> st.getGamesPlayed() > 5 && !st.getIsInjured() && !st.getIsSuspended())
                .sorted(Comparator.comparing(FootballSquadPlayerSeasonStats::ycAverage).reversed())
                .limit(5)
                .collect(Collectors.toList());

        List<FootballSquadPlayerSeasonStats> fromTop5 = top5TeamYCardsPlayers.stream().filter(p -> futureSquadStats.contains(p)).collect(Collectors.toList());

        System.out.println("n of top 5 yc players = " + fromTop5.size() + " (" + fromTop5.toString() + ") players");
        System.out.println("average yc/gms from top 5 yc players = " + fromTop5.stream().mapToDouble(st -> st.ycAverage()).average().orElse(0));
        System.out.println("average match squad without from top 5 yc/gms  = " + futureSquadStats.stream()
                .filter(st -> !fromTop5.contains(st))
                .mapToDouble(st -> st.ycAverage()).average().orElse(0));
        System.out.println("average match squad yc/gms  = " + futureSquadStats.stream().mapToDouble(st -> st.ycAverage()).average().getAsDouble());
        System.out.println("less 5 games played = " + futureSquadStats.stream().filter(st -> st.getGamesPlayed() <= 5).count() + " players");
    }

    FootballSquadPlayerSeasonStats getStatsByPlayer(Set<FootballSquadPlayerSeasonStats> squadPlayersStats, FutureMatchSquadPlayer player) {
        Optional<FootballSquadPlayerSeasonStats> playerStats = squadPlayersStats.stream()
                .filter(st -> st.getPlayer().getMyscoreCode().equals(player.getMyscoreCode())).findFirst();
        if (!playerStats.isPresent()) {
            System.out.println("strange, player not found = " + player);
            return null;
        }
        return playerStats.get();

    }


}
