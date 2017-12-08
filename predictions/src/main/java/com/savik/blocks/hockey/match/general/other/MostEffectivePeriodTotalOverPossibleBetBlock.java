package com.savik.blocks.hockey.match.general.other;


import com.savik.ContainerType;
import com.savik.PossibleBetContainer;
import com.savik.bets.hockey.other.MostEffectivePeriodTotalOverPossibleBet;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;

class MostEffectivePeriodTotalOverPossibleBetBlock extends PossibleBetContainer<HockeyMatch> {
    public MostEffectivePeriodTotalOverPossibleBetBlock() {
        super(
                Arrays.asList(
                        new PossibleBetContainer<>(
                                new MostEffectivePeriodTotalOverPossibleBet(2.5),
                                ContainerType.OVER_2_5
                        ),
                        new PossibleBetContainer<>(
                                new MostEffectivePeriodTotalOverPossibleBet(3.5),
                                ContainerType.OVER_3_5
                        )
                ), ContainerType.MOST_EFFECTIVE_PERIOD_TOTAL_OVER
        );
    }
}
