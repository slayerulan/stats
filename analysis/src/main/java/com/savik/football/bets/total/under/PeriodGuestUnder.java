package com.savik.football.bets.total.under;

import com.savik.Period;
import com.savik.football.bets.PeriodBet;
import lombok.Getter;

@Getter
public class PeriodGuestUnder extends PeriodBet {

    private double amount;

    public PeriodGuestUnder(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean canAnalyze(Period period) {
        return period.getGuestScore() != null;
    }

    @Override
    public boolean check(Period period) {
        return period.getGuestScore() < amount;
    }
}
