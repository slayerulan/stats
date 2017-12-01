package com.savik.blocks.general.result;

import com.savik.Match;
import com.savik.PeriodBetContainer;
import com.savik.bets.general.result.PeriodAnyWinner;


public class PeriodAnyWinBlock<T extends Match> extends PeriodBetContainer {

    public PeriodAnyWinBlock() {
        super(new PeriodAnyWinner());
    }

}
