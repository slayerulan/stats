package com.savik.possible_bets.hockey.match.general.other;


import com.savik.ContainerType;
import com.savik.Period;
import com.savik.PossibleBetContainer;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;
import java.util.function.Function;

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
