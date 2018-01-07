package com.savik.parser.snooker.matches;

import com.savik.Season;
import com.savik.Winner;
import com.savik.parser.Downloader;
import com.savik.snooker.model.SnookerBookieStats;
import com.savik.snooker.model.SnookerChampionship;
import com.savik.snooker.model.SnookerMatch;
import com.savik.snooker.model.SnookerTeam;
import com.savik.snooker.repository.SnookerTeamRepository;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;


@Service
public class SnookerSingleMatchParser {

    @Autowired
    SnookerTeamRepository snookerTeamRepository;

    @Autowired
    Downloader downloader;

    public SnookerMatch parse(String matchId, SnookerChampionship snookerChampionship, Season season) {

        Document generalInfo = downloader.downloadGeneralInfo(matchId);
        Document summaryInfo = downloader.downloadSummaryInfo(matchId);
        Document oddsInfo = downloader.downloadSnookerOddsInfo(matchId);


        String homeTeam = summaryInfo.select(".tname-home a").text();
        String guestTeam = summaryInfo.select(".tname-away a").text();

        String outerHtml = summaryInfo.outerHtml();
        Long epoch = Long.valueOf(outerHtml.substring(
                outerHtml.indexOf("game_utime") + 13,
                outerHtml.indexOf("game_utime") + 23
        ));

        LocalDateTime dateTime = Instant.ofEpochSecond(epoch).atZone(ZoneId.systemDefault()).toLocalDateTime();

        SnookerTeam home = snookerTeamRepository.findOneByNameAndChampionship(homeTeam, snookerChampionship);
        SnookerTeam guest = snookerTeamRepository.findOneByNameAndChampionship(guestTeam, snookerChampionship);

        if (generalInfo.select("tr.odd td.score:not(.best-of)").isEmpty()) {
            return null;
        }
        Integer homeScore = Integer.valueOf(generalInfo.select("tr.odd td.score:not(.best-of)").first().text());
        Integer guestScore = Integer.valueOf(generalInfo.select("tr.even td.score:not(.best-of)").first().text());

        SnookerBookieStats snookerBookieStats = null;

        String body = oddsInfo.getElementsByTag("body").text();
        String oddsString = body.substring(body.indexOf("MI÷") + 3, body.indexOf("¬MJ"));


        if (!oddsString.isEmpty() && !oddsString.equals("-|-")) {
            List<String> oddValues = Arrays.asList(oddsString.split("\\|"));
            snookerBookieStats = SnookerBookieStats.builder()
                    .homeRate(Double.valueOf(oddValues.get(0)))
                    .guestRate(Double.valueOf(oddValues.get(1)))
                    .build();
        }

        SnookerMatch snookerMatch = SnookerMatch.builder()
                .homeTeam(home)
                .guestTeam(guest)
                .homeScore(homeScore)
                .guestScore(guestScore)
                .totalScore(homeScore + guestScore)
                .winner(homeScore > guestScore ? Winner.HOME : Winner.GUEST)
                .date(dateTime)
                .season(season)
                .championship(snookerChampionship)
                .bookieStats(snookerBookieStats)
                .myscoreCode(matchId)
                .build();


        return snookerMatch;
    }
}
