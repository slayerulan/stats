package com.savik.bets.general.other;

import com.savik.Period;
import com.savik.PeriodBet;
import com.savik.bets.general.total.under.PeriodUnder;
import lombok.Getter;

@Getter
public class PeriodWinAndUnder extends PeriodBet {

    private PeriodBet whoWon;
    private PeriodUnder periodUnder;

    public PeriodWinAndUnder(double amount, PeriodBet whoWon) {
        this.whoWon = whoWon;
        this.periodUnder = new PeriodUnder(amount);
    }

    @Override
    public boolean canAnalyze(Period period) {
        return whoWon.canAnalyze(period) && periodUnder.canAnalyze(period);
    }

    @Override
    public boolean check(Period period) {
        return whoWon.check(period) && periodUnder.check(period);
    }
}
