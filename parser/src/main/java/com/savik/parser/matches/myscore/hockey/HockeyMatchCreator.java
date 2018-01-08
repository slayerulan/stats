package com.savik.parser.matches.myscore.hockey;

import com.codiform.moo.curry.Update;
import com.savik.Period;
import com.savik.Season;
import com.savik.Who;
import com.savik.Winner;
import com.savik.football.model.FootballPeriod;
import com.savik.hockey.model.*;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
@Builder
public class HockeyMatchCreator {

    HockeyMatchInfoParser.GeneralInfoDto matchGeneralInfoDto;

    HockeyMatchInfoParser.GeneralInfoDto firstPeriodGeneralInfoDto;

    HockeyMatchInfoParser.GeneralInfoDto secondPeriodGeneralInfoDto;

    HockeyMatchInfoParser.GeneralInfoDto thirdPeriodGeneralInfoDto;

    HockeyMatchInfoParser.GeneralInfoDto overtimeGeneralInfoDto;

    HockeyMatchInfoParser.StatsInfoDto matchStatsInfoDto;

    HockeyMatchInfoParser.StatsInfoDto firstPeriodStatsInfoDto;

    HockeyMatchInfoParser.StatsInfoDto secondPeriodStatsInfoDto;

    HockeyMatchInfoParser.StatsInfoDto thirdPeriodStatsInfoDto;

    HockeyMatchInfoParser.StatsInfoDto overtimeStatsInfoDto;

    HockeyTeam homeTeam;

    HockeyTeam guestTeam;

    HockeyChampionship championship;

    Season season;

    LocalDateTime date;

    String myscoreCode;

    HockeyBookieStats bookieStats;

    public HockeyMatch createMatch() {
        return HockeyMatch.builder()
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

    private HockeyMatchInfo createMatchInfo() {
        HockeyPeriod firstPeriod = createPeriod(
                firstPeriodGeneralInfoDto,
                firstPeriodStatsInfoDto,
                Period.PeriodStatus.FIRST
        );
        HockeyPeriod secondPeriod = createPeriod(
                secondPeriodGeneralInfoDto,
                secondPeriodStatsInfoDto,
                Period.PeriodStatus.SECOND
        );
        HockeyPeriod thirdPeriod = createPeriod(
                thirdPeriodGeneralInfoDto,
                thirdPeriodStatsInfoDto,
                Period.PeriodStatus.THIRD
        );
        HockeyPeriod overtime = null;
        if(overtimeGeneralInfoDto != null && overtimeStatsInfoDto != null) {
            overtime = createPeriod(
                    overtimeGeneralInfoDto,
                    overtimeStatsInfoDto,
                    Period.PeriodStatus.OVERTIME
            );

        }
        HockeyPeriod match = createPeriod(matchGeneralInfoDto, matchStatsInfoDto, FootballPeriod.PeriodStatus.MATCH);
        return HockeyMatchInfo.builder()
                                .firstPeriod(firstPeriod)
                                .secondPeriod(secondPeriod)
                                .thirdPeriod(thirdPeriod)
                                .overtime(overtime)
                                .match(match)
                                .build();
    }

    private HockeyPeriod createPeriod(
            HockeyMatchInfoParser.GeneralInfoDto infoDto,
            HockeyMatchInfoParser.StatsInfoDto statsDto,
            FootballPeriod.PeriodStatus periodStatus
    ) {
        HockeyPeriod period = new HockeyPeriod();
        if (statsDto != null) {
            Update.from(statsDto).to(period);
        }

        Set<HockeyGoal> footballGoals = null;
        if (periodStatus != FootballPeriod.PeriodStatus.MATCH) {

            footballGoals = infoDto
                    .getHockeyGoals()
                    .stream()
                    .map(c -> c.toBuilder().team(c.getWhoScored() == Who.HOME ? homeTeam : guestTeam).build())
                    .collect(Collectors.toSet());
        }


        Integer homeScore = (int) infoDto.getHockeyGoals().stream().filter(g -> g.getWhoScored() == Who.HOME).count();
        Integer guestScore = (int) infoDto.getHockeyGoals().stream().filter(g -> g.getWhoScored() == Who.GUEST).count();
        if(periodStatus != FootballPeriod.PeriodStatus.MATCH && footballGoals.size() != homeScore + guestScore) {
            throw new RuntimeException("parsed goals size not equals total score");
        }
        return period.toBuilder()
                .goals(footballGoals)
                .homeScore(homeScore)
                .guestScore(guestScore)
                .totalScore(homeScore + guestScore)
                .winner(homeScore > guestScore ? Winner.HOME : homeScore < guestScore ? Winner.GUEST : Winner.DRAW)
                .periodStatus(periodStatus)
                .homeMinorPenaltiesAmount(infoDto.getHomeMinorPenaltiesAmount())
                .guestMinorPenaltiesAmount(infoDto.getGuestMinorPenaltiesAmount())
                .build();
    }
}
