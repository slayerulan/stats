package com.savik.bets.football.offsides;

import com.savik.PeriodBet;
import com.savik.football.model.FootballPeriod;
import lombok.Getter;

@Getter
public class PeriodHomeOffsidesTotalOver extends PeriodBet<FootballPeriod> {

    private double amount;

    public PeriodHomeOffsidesTotalOver(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean canAnalyze(FootballPeriod period) {
        return period.getHomeOffsides() != null;
    }

    @Override
    public boolean check(FootballPeriod period) {
        return period.getHomeOffsides() > amount;
    }
}
