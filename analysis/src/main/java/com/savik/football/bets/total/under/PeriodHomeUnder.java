package com.savik.football.bets.total.under;

import com.savik.Period;
import com.savik.football.bets.PeriodBet;
import lombok.Getter;

@Getter
public class PeriodHomeUnder extends PeriodBet {

    private double amount;

    public PeriodHomeUnder(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean canAnalyze(Period period) {
        return period.getHomeScore() != null;
    }

    @Override
    public boolean check(Period period) {
        return period.getHomeScore() < amount;
    }
}
