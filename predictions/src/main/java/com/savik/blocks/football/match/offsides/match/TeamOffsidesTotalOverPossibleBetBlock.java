package com.savik.blocks.football.match.offsides.match;


import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.PossibleBetContainer;
import com.savik.bets.football.offsides.PeriodTeamOffsidesTotalOverPossibleBet;
import com.savik.football.model.FootballMatch;

import java.util.Arrays;

public class TeamOffsidesTotalOverPossibleBetBlock extends PossibleBetContainer<FootballMatch> {
    public TeamOffsidesTotalOverPossibleBetBlock(MatchData homeMatchData, MatchData guestMatchData) {
        super(Arrays.asList(
                new PossibleBetContainer<>(
                        new PeriodTeamOffsidesTotalOverPossibleBet(homeMatchData, guestMatchData, FootballMatch.MATCH, 1.5),
                        ContainerType.OVER_1_5
                ),
                new PossibleBetContainer<>(
                        new PeriodTeamOffsidesTotalOverPossibleBet(homeMatchData, guestMatchData, FootballMatch.MATCH, 2.5),
                        ContainerType.OVER_2_5
                ),
                new PossibleBetContainer<>(
                        new PeriodTeamOffsidesTotalOverPossibleBet(homeMatchData, guestMatchData, FootballMatch.MATCH, 3.5),
                        ContainerType.OVER_3_5
                ),
                new PossibleBetContainer<>(
                        new PeriodTeamOffsidesTotalOverPossibleBet(homeMatchData, guestMatchData, FootballMatch.MATCH, 4.5),
                        ContainerType.OVER_4_5
                )
                ), ContainerType.TEAM_TOTAL_OVER
        );
    }
}
