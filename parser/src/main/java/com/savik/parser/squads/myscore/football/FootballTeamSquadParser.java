package com.savik.parser.squads.myscore.football;

import com.savik.football.model.FootballFutureMatch;
import com.savik.football.model.FootballSquadPlayeer;
import com.savik.football.model.FootballTeam;
import com.savik.football.model.FootballTeamSquad;
import com.savik.football.repository.FootballTeamSquadRepository;
import com.savik.parser.Downloader;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

import static com.savik.football.specifications.FootballTeamSquadSpec.hasTeam;

/**
 * @author Savushkin Yauheni
 * @since 12.04.2017
 */
@Service
public class FootballTeamSquadParser {

    @Autowired
    FootballTeamSquadRepository footballTeamSquadRepository;


    @Autowired
    Downloader downloader;

    public void parse(FootballFutureMatch futureMatch) {
        Document summaryInfo = downloader.downloadSummaryInfo(futureMatch.getMyscoreCode());
        Elements elements = summaryInfo.select("span.tname");
        String homePrefix = getTeamPrefixFromHref(elements.get(0));
        String guestPrefix = getTeamPrefixFromHref(elements.get(1));
        Document homeTeamInfo = downloader.downloadTeamInfo(homePrefix);
        Document guesteamInfo = downloader.downloadTeamInfo(guestPrefix);
        FootballTeamSquad homeSquad = parseFootballTeamSquad(homeTeamInfo, futureMatch, futureMatch.getHomeTeam());
        FootballTeamSquad guestSquad = parseFootballTeamSquad(guesteamInfo, futureMatch, futureMatch.getGuestTeam());

        FootballTeamSquad homeSquadPersisted = footballTeamSquadRepository.findOne(hasTeam(futureMatch.getHomeTeam()));
        if(homeSquadPersisted != null) {
            homeSquadPersisted.setSquadPlayers(homeSquad.getSquadPlayers());
            footballTeamSquadRepository.save(homeSquadPersisted);
        } else {
            footballTeamSquadRepository.save(homeSquad);
        }

        FootballTeamSquad guestSquadPersisted = footballTeamSquadRepository.findOne(hasTeam(futureMatch.getGuestTeam()));
        if(guestSquadPersisted != null) {
            guestSquadPersisted.setSquadPlayers(guestSquad.getSquadPlayers());
            footballTeamSquadRepository.save(guestSquadPersisted);
        } else {
            footballTeamSquadRepository.save(guestSquad);
        }
    }

    private FootballTeamSquad parseFootballTeamSquad(Document teamInfo, FootballFutureMatch futureMatch, FootballTeam team) {
        Set<FootballSquadPlayeer> squadPlayeers = parseFootballSquadPlayers(teamInfo);
        FootballTeamSquad teamSquad = FootballTeamSquad.builder()
                .championship(futureMatch.getChampionship())
                .season(futureMatch.getSeason())
                .team(team)
                .squadPlayers(squadPlayeers)
                .build();
        return teamSquad;
    }

    private Set<FootballSquadPlayeer> parseFootballSquadPlayers(Document teamInfo) {
        Element table = teamInfo.select("table.squad-table").first();
        Elements players = table.select(".player");
        Set<FootballSquadPlayeer> squadPlayers = new HashSet<>();
        for (Element player : players) {
            Element playerNameTd = player.select(".player-name").first();
            Elements tds = player.select("> td");

            String playerName = playerNameTd.select("a").first().text();
            Boolean isInjured = !playerNameTd.select("span.injury").isEmpty();
            Boolean isSuspended = !playerNameTd.select("span.suspended").isEmpty();
            Integer gamesPlayed = Integer.valueOf(tds.get(3).text());
            Integer goalsScored = Integer.valueOf(tds.get(4).text());
            Integer yellowCardsAmount = Integer.valueOf(tds.get(5).text());
            Integer redCardsAmount = Integer.valueOf(tds.get(6).text());

            FootballSquadPlayeer squadPlayeer = FootballSquadPlayeer.builder()
                    .name(playerName)
                    .gamesPlayed(gamesPlayed)
                    .goalsScored(goalsScored)
                    .yellowCardsAmount(yellowCardsAmount)
                    .redCardsAmount(redCardsAmount)
                    .isInjured(isInjured)
                    .isSuspended(isSuspended)
                    .build();
            squadPlayers.add(squadPlayeer);
        }
        return squadPlayers;
    }

    private String getTeamPrefixFromHref(Element element) {
        String homeprefix = element.select("a").first().attr("onclick");
        String[] split = homeprefix.split("'");
        return split[1];
    }

}
