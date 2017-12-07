package com.savik.bets.general.total.over;

import com.savik.Period;
import com.savik.PeriodBet;
import lombok.Getter;

@Getter
public class PeriodOver<T extends Period> extends PeriodBet<T> {

    private double amount;

    public PeriodOver(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean canAnalyze(Period period) {
        return period.getTotalScore() != null;
    }

    @Override
    public boolean check(Period period) {
        return period.getTotalScore() > amount;
    }
}
