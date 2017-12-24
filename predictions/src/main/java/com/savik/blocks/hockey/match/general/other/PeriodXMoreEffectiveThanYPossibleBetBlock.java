package com.savik.blocks.hockey.match.general.other;


import com.savik.ContainerType;
import com.savik.Period;
import com.savik.PossibleBetContainer;
import com.savik.bets.hockey.other.PeriodXMoreEffectiveThanYPossibleBet;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;

class PeriodXMoreEffectiveThanYPossibleBetBlock extends PossibleBetContainer<HockeyMatch> {
    public PeriodXMoreEffectiveThanYPossibleBetBlock() {
        super(
                Arrays.asList(
                        new PossibleBetContainer<>(
                                new PeriodXMoreEffectiveThanYPossibleBet(Period.PeriodStatus.SECOND, Period.PeriodStatus.FIRST),
                                ContainerType.P2_MORE_P1
                        ),
                        new PossibleBetContainer<>(
                                new PeriodXMoreEffectiveThanYPossibleBet(Period.PeriodStatus.THIRD, Period.PeriodStatus.SECOND),
                                ContainerType.P3_MORE_P2
                        ),
                        new PossibleBetContainer<>(
                                new PeriodXMoreEffectiveThanYPossibleBet(Period.PeriodStatus.THIRD, Period.PeriodStatus.FIRST),
                                ContainerType.P3_MORE_P1
                        )
                ), ContainerType.PERIOD_X_MORE_EFFECTIVE_THAN_Y
        );
    }
}
