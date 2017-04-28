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

    Team homeTeam;

    Team guestTeam;

    Championship championship;

    Season season;

    LocalDateTime date;

    String myscoreCode;

    public Match createMatch() {
        return Match.builder()
                    .myscoreCode(myscoreCode)
                    .season(season)
                    .championship(championship)
                    .date(date)
                    .matchInfo(createMatchInfo())
                    .homeTeam(homeTeam)
                    .guestTeam(guestTeam)
                    .build();
    }

    private MatchInfo createMatchInfo() {
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
        return MatchInfo.builder()
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

        Set<Card> cards = null;
        Set<Goal> goals = null;
        if (periodStatus != Period.PeriodStatus.MATCH) {
            cards = infoDto
                    .getCards()
                    .stream()
                    .map(c -> c.toBuilder().team(c.getWho() == Who.HOME ? homeTeam : guestTeam).build())
                    .collect(Collectors.toSet());

            goals = infoDto
                    .getGoals()
                    .stream()
                    .map(c -> c.toBuilder().team(c.getWhoScored() == Who.HOME ? homeTeam : guestTeam).build())
                    .collect(Collectors.toSet());
        }


        Integer homeScore = goals != null ? (int) goals.stream().filter(g -> g.getWhoScored() == Who.HOME).count() : null;
        Integer guestScore = goals != null ? (int) goals.stream().filter(g -> g.getWhoScored() == Who.GUEST).count() : null;
        return period.toBuilder()
                     .goals(goals)
                     .cards(cards)
                     .homeScore(homeScore)
                     .guestScore(guestScore)
                     .totalScore(goals != null ? goals.size() : null)
                     .winner(homeScore > guestScore ? Winner.HOME : homeScore < guestScore ? Winner.GUEST : Winner.DRAW)
                     .periodStatus(periodStatus)
                     .build();
    }
}
