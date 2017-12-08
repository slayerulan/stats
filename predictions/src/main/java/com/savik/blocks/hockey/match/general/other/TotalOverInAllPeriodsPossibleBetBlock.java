package com.savik.blocks.hockey.match.general.other;


import com.savik.ContainerType;
import com.savik.PossibleBetContainer;
import com.savik.bets.hockey.other.TotalOverInAllPeriodsPossibleBet;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;

class TotalOverInAllPeriodsPossibleBetBlock extends PossibleBetContainer<HockeyMatch> {
    public TotalOverInAllPeriodsPossibleBetBlock() {
        super(
                Arrays.asList(
                        new PossibleBetContainer<>(
                                new TotalOverInAllPeriodsPossibleBet(0.5),
                                ContainerType.OVER_0_5
                        )
                ), ContainerType.TOTAL_OVER_ALL_PERIODS
        );
    }
}
