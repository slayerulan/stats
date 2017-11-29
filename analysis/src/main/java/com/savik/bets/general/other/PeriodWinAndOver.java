package com.savik.bets.general.other;

import com.savik.Period;
import com.savik.PeriodBet;
import com.savik.bets.general.total.over.PeriodOver;
import lombok.Getter;

@Getter
public class PeriodWinAndOver extends PeriodBet {

    private PeriodBet whoWon;
    private PeriodOver periodOver;

    public PeriodWinAndOver(double amount, PeriodBet whoWon) {
        this.whoWon = whoWon;
        this.periodOver = new PeriodOver(amount);
    }

    @Override
    public boolean canAnalyze(Period period) {
        return whoWon.canAnalyze(period) && periodOver.canAnalyze(period);
    }

    @Override
    public boolean check(Period period) {
        return whoWon.check(period) && periodOver.check(period);
    }
}
