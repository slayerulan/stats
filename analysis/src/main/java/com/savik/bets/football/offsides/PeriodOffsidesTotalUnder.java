package com.savik.bets.football.offsides;

import com.savik.PeriodBet;
import com.savik.football.model.FootballPeriod;
import lombok.Getter;

@Getter
public class PeriodOffsidesTotalUnder extends PeriodBet<FootballPeriod> {

    private double amount;

    public PeriodOffsidesTotalUnder(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean canAnalyze(FootballPeriod period) {
        return period.hasOffsides();
    }

    @Override
    public boolean check(FootballPeriod period) {
        return period.getOffsidesTotal() < amount;
    }
}
