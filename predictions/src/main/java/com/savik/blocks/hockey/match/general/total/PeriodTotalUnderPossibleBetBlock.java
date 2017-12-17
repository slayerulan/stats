package com.savik.blocks.hockey.match.general.total;


import com.savik.ContainerType;
import com.savik.PossibleBetContainer;
import com.savik.bets.general.total.PeriodTotalUnderPossibleBet;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;

public class PeriodTotalUnderPossibleBetBlock extends PossibleBetContainer<HockeyMatch> {
    public PeriodTotalUnderPossibleBetBlock() {
        super(Arrays.asList(
                new PossibleBetContainer<>(
                        new PeriodTotalUnderPossibleBet<>(HockeyMatch.MATCH, 4.5),
                        ContainerType.UNDER_4_5
                ),
                new PossibleBetContainer<>(
                        new PeriodTotalUnderPossibleBet<>(HockeyMatch.MATCH, 5.5),
                        ContainerType.UNDER_5_5
                ),
                new PossibleBetContainer<>(
                        new PeriodTotalUnderPossibleBet<>(HockeyMatch.MATCH, 6.5),
                        ContainerType.UNDER_6_5
                )
                ), ContainerType.TOTAL_UNDER
        );
    }
}
