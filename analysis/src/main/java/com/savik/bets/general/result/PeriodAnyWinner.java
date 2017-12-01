package com.savik.bets.general.result;

import com.savik.Period;
import com.savik.PeriodBet;
import com.savik.Winner;
import lombok.Getter;

@Getter
public class PeriodAnyWinner extends PeriodBet {

    @Override
    public boolean canAnalyze(Period period) {
        return period.getWinner() != null;
    }

    @Override
    public boolean check(Period period) {
        return period.getWinner() != Winner.DRAW;
    }
}
