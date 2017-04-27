package com.savik.parser.football;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

import com.codiform.moo.curry.Update;
import com.savik.football.model.Card;
import com.savik.football.model.Championship;
import com.savik.football.model.Goal;
import com.savik.football.model.Match;
import com.savik.football.model.MatchInfo;
import com.savik.football.model.Period;
import com.savik.football.model.Season;
import com.savik.football.model.Team;
import com.savik.football.model.Who;
import com.savik.football.model.Winner;
import lombok.*;

@AllArgsConstructor
@Builder
public class MatchCreator {


    MatchInfoParser.GeneralInfoDto firstPeriodGeneralInfoDto;

    MatchInfoParser.GeneralInfoDto secondPeriodGeneralInfoDto;


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
        return MatchInfo.builder()
                        .firstPeriod(firstPeriod)
                        .secondPeriod(secondPeriod)
                        .build();
    }

    private Period createPeriod(
            MatchInfoParser.GeneralInfoDto infoDto,
            MatchInfoParser.StatsInfoDto statsDto,
            Period.PeriodStatus periodStatus
    ) {
        Period period = new Period();
        Update.from(statsDto).to(period);

        Set<Card> cards = infoDto
                .getCards()
                .stream()
                .map(c -> c.toBuilder().team(c.getWho() == Who.HOME ? homeTeam : guestTeam).build())
                .collect(Collectors.toSet());

        Set<Goal> goals = infoDto
                .getGoals()
                .stream()
                .map(c -> c.toBuilder().team(c.getWhoScored() == Who.HOME ? homeTeam : guestTeam).build())
                .collect(Collectors.toSet());

        int homeScore = (int) goals.stream().filter(g -> g.getWhoScored() == Who.HOME).count();
        int guestScore = (int) goals.stream().filter(g -> g.getWhoScored() == Who.GUEST).count();
        return period.toBuilder()
                     .goals(goals)
                     .cards(cards)
                     .homeScore(homeScore)
                     .guestScore(guestScore)
                     .totalScore(goals.size())
                     .winner(homeScore > guestScore ? Winner.HOME : homeScore < guestScore ? Winner.GUEST : Winner.DRAW)
                     .periodStatus(periodStatus)
                     .build();
    }
}
