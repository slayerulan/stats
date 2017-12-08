package com.savik.blocks.hockey.match.general.other;


import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.PossibleBetContainer;
import com.savik.bets.general.other.TeamWinAtLeastNPeriodsPossibleBet;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;

class TeamWinAtLeastNPeriodsPossibleBetBlock extends PossibleBetContainer<HockeyMatch> {
    public TeamWinAtLeastNPeriodsPossibleBetBlock(MatchData homeMatchData, MatchData guestMatchData) {
        super(
                Arrays.asList(
                        new PossibleBetContainer<>(
                                new TeamWinAtLeastNPeriodsPossibleBet<>(homeMatchData, guestMatchData, 1),
                                ContainerType.NUMBER_1
                        ),
                        new PossibleBetContainer<>(
                                new TeamWinAtLeastNPeriodsPossibleBet<>(homeMatchData, guestMatchData, 2),
                                ContainerType.NUMBER_2
                        )
                ), ContainerType.TEAM_WIN_AT_LEAST_N_PERIODS
        );
    }
}
