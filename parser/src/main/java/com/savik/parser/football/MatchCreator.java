package com.savik.parser.football;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

import com.codiform.moo.curry.Update;
import com.savik.football.model.*;
import lombok.*;

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
                            .build();
    }

    private FootballMatchInfo createMatchInfo() {
        Period firstPeriod = createPeriod(
                firstPeriodGeneralInfoDto,
                firstPeriodStatsInfoDto,
                Period.PeriodStatus.FIRST
        );
        Period secondPeriod = createPeriod(
                secondPeriodGeneralInfoDto,
                secondPeriodStatsInfoDto,
                Period.PeriodStatus.SECOND
        );
        Period match = createPeriod(matchGeneralInfoDto, matchStatsInfoDto, Period.PeriodStatus.MATCH);
        return FootballMatchInfo.builder()
                                .firstPeriod(firstPeriod)
                                .secondPeriod(secondPeriod)
                                .match(match)
                                .build();
    }

    private Period createPeriod(
            MatchInfoParser.GeneralInfoDto infoDto,
            MatchInfoParser.StatsInfoDto statsDto,
            Period.PeriodStatus periodStatus
    ) {
        Period period = new Period();
        if (statsDto != null) {
            Update.from(statsDto).to(period);
        }

        Set<FootballCard> footballCards = null;
        Set<FootballGoal> footballGoals = null;
        if (periodStatus != Period.PeriodStatus.MATCH) {
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
