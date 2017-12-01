package com.savik.blocks.general.result;

import com.savik.Match;
import com.savik.PeriodBetContainer;
import com.savik.bets.general.result.PeriodResultDifference;


public class PeriodAnyWinAndDiffEqualsBlock<T extends Match> extends PeriodBetContainer {

    public PeriodAnyWinAndDiffEqualsBlock(int diff) {
        super(new PeriodResultDifference(diff));
    }

}
