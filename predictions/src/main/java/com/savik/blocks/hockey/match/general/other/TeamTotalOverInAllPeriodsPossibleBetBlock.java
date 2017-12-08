package com.savik.blocks.hockey.match.general.other;


import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.PossibleBetContainer;
import com.savik.bets.general.other.PeriodTeamTotalOverInAllPeriodsPossibleBet;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;

class TeamTotalOverInAllPeriodsPossibleBetBlock extends PossibleBetContainer<HockeyMatch> {
    public TeamTotalOverInAllPeriodsPossibleBetBlock(MatchData homeMatchData, MatchData guestMatchData) {
        super(
                Arrays.asList(
                        new PossibleBetContainer<>(
                                new PeriodTeamTotalOverInAllPeriodsPossibleBet<>(homeMatchData, guestMatchData, 0.5),
                                ContainerType.OVER_0_5
                        )
                ), ContainerType.TEAM_TOTAL_OVER_ALL_PERIODS
        );
    }
}
