package com.savik.blocks.hockey.match.general.other;


import com.savik.ContainerType;
import com.savik.PossibleBetContainer;
import com.savik.bets.general.other.PeriodAnyWinAndTotalUnderPossibleBet;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;

class PeriodAnyWinAndTotalUnderPossibleBetBlock extends PossibleBetContainer<HockeyMatch> {
    public PeriodAnyWinAndTotalUnderPossibleBetBlock() {
        super(Arrays.asList(
                new PossibleBetContainer<>(
                        new PeriodAnyWinAndTotalUnderPossibleBet(HockeyMatch.MATCH, 5.5),
                        ContainerType.UNDER_5_5
                )), ContainerType.ANY_WIN_AND_TOTAL_UNDER
        );
    }
}
