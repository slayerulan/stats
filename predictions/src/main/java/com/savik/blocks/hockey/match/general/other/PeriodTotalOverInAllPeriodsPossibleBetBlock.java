package com.savik.blocks.hockey.match.general.other;


import com.savik.ContainerType;
import com.savik.PossibleBetContainer;
import com.savik.bets.hockey.other.PeriodTotalOverInAllPeriodsPossibleBet;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;

class PeriodTotalOverInAllPeriodsPossibleBetBlock extends PossibleBetContainer<HockeyMatch> {
    public PeriodTotalOverInAllPeriodsPossibleBetBlock() {
        super(
                Arrays.asList(
                        new PossibleBetContainer<>(
                                new PeriodTotalOverInAllPeriodsPossibleBet(0.5),
                                ContainerType.OVER_0_5
                        )
                ), ContainerType.TOTAL_OVER_ALL_PERIODS
        );
    }
}
