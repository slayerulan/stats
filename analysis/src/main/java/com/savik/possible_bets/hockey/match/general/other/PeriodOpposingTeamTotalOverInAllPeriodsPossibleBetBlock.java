package com.savik.possible_bets.hockey.match.general.other;


import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.PossibleBetContainer;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;

class PeriodOpposingTeamTotalOverInAllPeriodsPossibleBetBlock extends PossibleBetContainer<HockeyMatch> {
    public PeriodOpposingTeamTotalOverInAllPeriodsPossibleBetBlock(MatchData homeMatchData, MatchData guestMatchData) {
        super(
                Arrays.asList(
                        new PossibleBetContainer<>(
                                new PeriodOpposingTeamTotalOverInAllPeriodsPossibleBet(homeMatchData, guestMatchData, 0.5),
                                ContainerType.OVER_0_5
                        )
                ), ContainerType.OPPOSING_TEAM_TOTAL_OVER_ALL_PERIODS
        );
    }
}
