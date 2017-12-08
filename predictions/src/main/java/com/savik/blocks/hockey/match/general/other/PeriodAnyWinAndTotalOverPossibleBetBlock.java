package com.savik.blocks.hockey.match.general.other;


import com.savik.ContainerType;
import com.savik.PossibleBetContainer;
import com.savik.bets.general.other.PeriodAnyWinAndTotalOverPossibleBet;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;

class PeriodAnyWinAndTotalOverPossibleBetBlock extends PossibleBetContainer<HockeyMatch> {
    public PeriodAnyWinAndTotalOverPossibleBetBlock() {

        super(Arrays.asList(
                new PossibleBetContainer<>(
                        new PeriodAnyWinAndTotalOverPossibleBet<>(HockeyMatch.MATCH, 5.5),
                        ContainerType.OVER_5_5
                )), ContainerType.ANY_WIN_AND_TOTAL_OVER
        );
    }
}
