package com.savik.blocks.hockey.other;

import com.savik.ContainerType;
import com.savik.GeneralBetContainer;
import com.savik.Period;
import com.savik.bets.hockey.other.PeriodXMoreEffectiveThanY;
import com.savik.hockey.model.HockeyMatch;

public class PeriodXMoreEffectiveThanYSingleBlock extends GeneralBetContainer<HockeyMatch> {

    public PeriodXMoreEffectiveThanYSingleBlock(Period.PeriodStatus x, Period.PeriodStatus y) {
        this(x, y, null);
    }

    public PeriodXMoreEffectiveThanYSingleBlock(Period.PeriodStatus x, Period.PeriodStatus y, ContainerType type) {
        super(
                new PeriodXMoreEffectiveThanY(x, y),
                type
        );
    }

}
