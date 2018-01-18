package com.savik.parser.squads.myscore.football;

import com.savik.football.model.*;
import com.savik.football.repository.FootballSquadPlayerRepository;
import com.savik.football.repository.FootballTeamSquadRepository;
import com.savik.parser.Downloader;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.savik.football.specifications.FootballTeamSquadSpec.hasTeam;

/**
 * @author Savushkin Yauheni
 * @since 12.04.2017
 */
@Service
public class FootballTeamSquadParser {

    public static final int MYSCORE_CODE_INDEX = 3;
    public static final int MYSCORE_URL_NAME_INDEX = 2;
    @Autowired
    FootballTeamSquadRepository footballTeamSquadRepository;

    @Autowired
    FootballSquadPlayerRepository footballSquadPlayerRepository;


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
        if (homeSquadPersisted != null) {
            homeSquadPersisted.setSquadPlayers(homeSquad.getSquadPlayers());
            footballTeamSquadRepository.save(homeSquadPersisted);
        } else {
            footballTeamSquadRepository.save(homeSquad);
        }

        FootballTeamSquad guestSquadPersisted = footballTeamSquadRepository.findOne(hasTeam(futureMatch.getGuestTeam()));
        if (guestSquadPersisted != null) {
            guestSquadPersisted.setSquadPlayers(guestSquad.getSquadPlayers());
            footballTeamSquadRepository.save(guestSquadPersisted);
        } else {
            footballTeamSquadRepository.save(guestSquad);
        }
    }

    public FutureMatchSquads parseFutureMatchSquads(FootballFutureMatch futureMatch) {
        Document document = downloader.downloadMatchSquads(futureMatch.getMyscoreCode());
        Element table = document.select("table.parts").first();
        if(table == null) {
            return null;
        }
        Elements trs = table.select("tbody > tr");
        Integer startingLineupIndexTo = table.select("tbody > tr > td.h-part:containsOwn(Замены)").first().parent().elementSiblingIndex();

        Set<FutureMatchSquadPlayer> homeLineUpPlayers = parsePlayers(trs.subList(1, startingLineupIndexTo), "fl", true);
        Set<FutureMatchSquadPlayer> guestLineUpPlayers = parsePlayers(trs.subList(1, startingLineupIndexTo), "fr", true);

        Set<FutureMatchSquadPlayer> homeSubstitutePlayers = parsePlayers(trs.subList(startingLineupIndexTo + 1, trs.size()), "fl", false);
        Set<FutureMatchSquadPlayer> guestSubstitutePlayers = parsePlayers(trs.subList(startingLineupIndexTo + 1, trs.size()), "fr", false);


        homeLineUpPlayers.addAll(homeSubstitutePlayers);
        guestLineUpPlayers.addAll(guestSubstitutePlayers);

        return FutureMatchSquads.builder()
                .homePlayers(homeLineUpPlayers)
                .guestPlayers(guestLineUpPlayers)
                .build();
    }

    private Set<FutureMatchSquadPlayer> parsePlayers(List<Element> players, String teamPrefix, boolean isLineUp) {
        Set<FutureMatchSquadPlayer> squadPlayers = new HashSet<>();
        for (Element player : players) {
            Element playerTd = player.select("td." + teamPrefix).first();
            Element playerATag = playerTd.select("div.name > a").first();
            if (playerATag == null) {
                continue;
            }
            String onclick = playerATag.attr("onclick");
            String[] split = onclick.split("/");
            List<Node> nodes = playerATag.childNodes();
            String playerName;
            if ((nodes.size() == 1 || nodes.size() == 2 || nodes.size() == 3) && nodes.get(0) instanceof TextNode) {
                playerName = nodes.get(0).toString();
            } else {
                throw new RuntimeException("name ??!?!?");
            }
            FutureMatchSquadPlayer squadPlayeer = FutureMatchSquadPlayer.builder()
                    .name(playerName)
                    .myscoreCode(split[MYSCORE_CODE_INDEX])
                    .myscoreUrlName(split[MYSCORE_URL_NAME_INDEX])
                    .isLineUp(isLineUp)
                    .build();
            squadPlayers.add(squadPlayeer);
        }
        return squadPlayers;
    }

    private FootballTeamSquad parseFootballTeamSquad(Document teamInfo, FootballFutureMatch futureMatch, FootballTeam team) {
        Set<FootballSquadPlayerSeasonStats> squadPlayeers = parseFootballSquadPlayersStats(teamInfo);
        FootballTeamSquad teamSquad = FootballTeamSquad.builder()
                .championship(futureMatch.getChampionship())
                .season(futureMatch.getSeason())
                .team(team)
                .squadPlayers(squadPlayeers)
                .build();
        return teamSquad;
    }

    private Set<FootballSquadPlayerSeasonStats> parseFootballSquadPlayersStats(Document teamInfo) {
        Element table = teamInfo.select("table.squad-table").first();
        Elements players = table.select(".player");
        Set<FootballSquadPlayerSeasonStats> squadPlayers = new HashSet<>();
        for (Element playerElement : players) {
            Element playerNameTd = playerElement.select(".player-name").first();
            Elements tds = playerElement.select("> td");

            Element playerATag = playerNameTd.select("a").first();
            String playerName = playerATag.text();
            String href = playerATag.attr("href");
            String[] split = href.split("/");
            FootballSquadPlayer player = footballSquadPlayerRepository.findByMyscoreCode(split[MYSCORE_CODE_INDEX]);
            if (player == null) {
                player = FootballSquadPlayer.builder()
                        .name(playerName)
                        .myscoreCode(split[MYSCORE_CODE_INDEX])
                        .myscoreUrlName(split[MYSCORE_URL_NAME_INDEX])
                        .build();
                footballSquadPlayerRepository.save(player);
            }


            Boolean isInjured = !playerNameTd.select("span.injury").isEmpty();
            Boolean isSuspended = !playerNameTd.select("span.suspended").isEmpty();
            Integer gamesPlayed = Integer.valueOf(tds.get(3).text());
            Integer goalsScored = Integer.valueOf(tds.get(4).text());
            Integer yellowCardsAmount = Integer.valueOf(tds.get(5).text());
            Integer redCardsAmount = Integer.valueOf(tds.get(6).text());

            FootballSquadPlayerSeasonStats squadPlayeer = FootballSquadPlayerSeasonStats.builder()
                    .player(player)
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
