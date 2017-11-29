package com.savik.general.bets.total.over;

import com.savik.Period;
import com.savik.PeriodBet;
import lombok.Getter;

@Getter
public class PeriodGuestOver extends PeriodBet {

    private double amount;

    public PeriodGuestOver(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean canAnalyze(Period period) {
        return period.getGuestScore() != null;
    }

    @Override
    public boolean check(Period period) {
        return period.getGuestScore() > amount;
    }
}
