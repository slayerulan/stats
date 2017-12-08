package com.savik.blocks.hockey.match.general.other;


import com.savik.ContainerType;
import com.savik.PossibleBetContainer;
import com.savik.bets.general.other.PeriodAnyWinAndDiffEqualsPossibleBet;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;

class PeriodAnyWinAndDiffEqualsPossibleBetBlock extends PossibleBetContainer<HockeyMatch> {
    public PeriodAnyWinAndDiffEqualsPossibleBetBlock() {
        super(Arrays.asList(
                new PossibleBetContainer<>(
                        new PeriodAnyWinAndDiffEqualsPossibleBet<>(HockeyMatch.MATCH, 1),
                        ContainerType.DIFF_1
                ),
                new PossibleBetContainer<>(
                        new PeriodAnyWinAndDiffEqualsPossibleBet<>(HockeyMatch.MATCH, 2),
                        ContainerType.DIFF_2
                )
                ), ContainerType.ANY_WIN_AND_DIFFERENCE_EQUALS
        );
    }
}
