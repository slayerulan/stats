package com.savik.blocks.hockey.match.general.other;


import com.savik.ContainerType;
import com.savik.PossibleBetContainer;
import com.savik.bets.hockey.other.TotalUnderInAllPeriodsPossibleBet;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;

class TotalUnderInAllPeriodsPossibleBetBlock extends PossibleBetContainer<HockeyMatch> {
    public TotalUnderInAllPeriodsPossibleBetBlock() {
        super(
                Arrays.asList(
                        new PossibleBetContainer<>(
                                new TotalUnderInAllPeriodsPossibleBet(2.5),
                                ContainerType.UNDER_2_5
                        ),
                        new PossibleBetContainer<>(
                                new TotalUnderInAllPeriodsPossibleBet(3.5),
                                ContainerType.UNDER_3_5
                        )
                ), ContainerType.TOTAL_UNDER_ALL_PERIODS
        );
    }
}
