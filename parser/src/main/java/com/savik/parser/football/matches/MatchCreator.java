package com.savik.parser.football.matches;

import com.codiform.moo.curry.Update;
import com.savik.Season;
import com.savik.Who;
import com.savik.Winner;
import com.savik.football.model.*;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
@Builder
public class MatchCreator {

    MatchInfoParser.GeneralInfoDto matchGeneralInfoDto;

    MatchInfoParser.GeneralInfoDto firstPeriodGeneralInfoDto;

    MatchInfoParser.GeneralInfoDto secondPeriodGeneralInfoDto;

    MatchInfoParser.StatsInfoDto matchStatsInfoDto;

    MatchInfoParser.StatsInfoDto firstPeriodStatsInfoDto;

    MatchInfoParser.StatsInfoDto secondPeriodStatsInfoDto;

    FootballTeam homeTeam;

    FootballTeam guestTeam;

    FootballChampionship championship;

    Season season;

    LocalDateTime date;

    String myscoreCode;

    FootballBookieStats bookieStats;

    FootballReferee footballReferee;

    public FootballMatch createMatch() {
        return FootballMatch.builder()
                .myscoreCode(myscoreCode)
                .season(season)
                .championship(championship)
                .date(date)
                .matchInfo(createMatchInfo())
                .homeTeam(homeTeam)
                .guestTeam(guestTeam)
                .bookieStats(bookieStats)
                .referee(footballReferee)
                .build();
    }

    private FootballMatchInfo createMatchInfo() {
        FootballPeriod firstPeriod = createPeriod(
                firstPeriodGeneralInfoDto,
                firstPeriodStatsInfoDto,
                FootballPeriod.PeriodStatus.FIRST
        );
        FootballPeriod secondPeriod = createPeriod(
                secondPeriodGeneralInfoDto,
                secondPeriodStatsInfoDto,
                FootballPeriod.PeriodStatus.SECOND
        );
        FootballPeriod match = createPeriod(matchGeneralInfoDto, matchStatsInfoDto, FootballPeriod.PeriodStatus.MATCH);
        return FootballMatchInfo.builder()
                .firstPeriod(firstPeriod)
                .secondPeriod(secondPeriod)
                .match(match)
                .build();
    }

    private FootballPeriod createPeriod(
            MatchInfoParser.GeneralInfoDto infoDto,
            MatchInfoParser.StatsInfoDto statsDto,
            FootballPeriod.PeriodStatus periodStatus
    ) {
        FootballPeriod period = new FootballPeriod();
        if (statsDto != null) {
            Update.from(statsDto).to(period);
        }

        Set<FootballCard> footballCards = null;
        Set<FootballGoal> footballGoals = null;
        if (periodStatus != FootballPeriod.PeriodStatus.MATCH) {
            footballCards = infoDto
                    .getFootballCards()
                    .stream()
                    .map(c -> c.toBuilder().team(c.getWho() == Who.HOME ? homeTeam : guestTeam).build())
                    .collect(Collectors.toSet());

            footballGoals = infoDto
                    .getFootballGoals()
                    .stream()
                    .map(c -> c.toBuilder().team(c.getWhoScored() == Who.HOME ? homeTeam : guestTeam).build())
                    .collect(Collectors.toSet());
        }


        Integer homeScore = (int) infoDto.getFootballGoals().stream().filter(g -> g.getWhoScored() == Who.HOME).count();
        Integer guestScore = (int) infoDto.getFootballGoals().stream().filter(g -> g.getWhoScored() == Who.GUEST).count();
        return period.toBuilder()
                .goals(footballGoals)
                .cards(footballCards)
                .homeScore(homeScore)
                .guestScore(guestScore)
                .totalScore(homeScore + guestScore)
                .winner(homeScore > guestScore ? Winner.HOME : homeScore < guestScore ? Winner.GUEST : Winner.DRAW)
                .periodStatus(periodStatus)
                .build();
    }
}
