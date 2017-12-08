package com.savik.blocks.hockey.match.general.total;


import com.savik.ContainerType;
import com.savik.PossibleBetContainer;
import com.savik.bets.general.total.PeriodTotalOverPossibleBet;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;

public class PeriodTotalOverPossibleBetBlock extends PossibleBetContainer<HockeyMatch> {
    public PeriodTotalOverPossibleBetBlock() {
        super(Arrays.asList(
                new PossibleBetContainer<>(
                        new PeriodTotalOverPossibleBet(HockeyMatch.MATCH, 4.5),
                        ContainerType.OVER_4_5
                ),
                new PossibleBetContainer<>(
                        new PeriodTotalOverPossibleBet(HockeyMatch.MATCH, 5.5),
                        ContainerType.OVER_5_5
                )
                ), ContainerType.TOTAL_OVER
        );
    }
}
