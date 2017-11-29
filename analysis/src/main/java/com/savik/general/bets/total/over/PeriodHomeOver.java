package com.savik.general.bets.total.over;

import com.savik.Period;
import com.savik.PeriodBet;
import lombok.Getter;

@Getter
public class PeriodHomeOver extends PeriodBet {

    private double amount;

    public PeriodHomeOver(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean canAnalyze(Period period) {
        return period.getHomeScore() != null;
    }

    @Override
    public boolean check(Period period) {
        return period.getHomeScore() > amount;
    }
}
