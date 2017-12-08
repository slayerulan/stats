package com.savik.blocks.hockey.match.general.other;


import com.savik.ContainerType;
import com.savik.PossibleBetContainer;
import com.savik.bets.general.other.DrawAtLeastNPeriodsPossibleBet;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;

class DrawAtLeastNPeriodsPossibleBetBlock extends PossibleBetContainer<HockeyMatch> {
    public DrawAtLeastNPeriodsPossibleBetBlock() {
        super(
                Arrays.asList(
                        new PossibleBetContainer<>(
                                new DrawAtLeastNPeriodsPossibleBet(1),
                                ContainerType.NUMBER_1
                        ),
                        new PossibleBetContainer<>(
                                new DrawAtLeastNPeriodsPossibleBet(2),
                                ContainerType.NUMBER_2
                        )
                ), ContainerType.DRAW_AT_LEAST_N_PERIODS
        );
    }
}
