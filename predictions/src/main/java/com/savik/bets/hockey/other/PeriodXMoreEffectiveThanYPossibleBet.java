package com.savik.bets.hockey.other;


import com.savik.Period;
import com.savik.PossibleBet;
import com.savik.blocks.hockey.other.PeriodXMoreEffectiveThanYSingleBlock;
import com.savik.hockey.model.HockeyMatch;

public class PeriodXMoreEffectiveThanYPossibleBet extends PossibleBet<HockeyMatch> {
    public PeriodXMoreEffectiveThanYPossibleBet(Period.PeriodStatus x, Period.PeriodStatus y) {
        super(
                new PeriodXMoreEffectiveThanYSingleBlock(x, y),
                new PeriodXMoreEffectiveThanYSingleBlock(x, y)
        );
    }
}
