package com.savik.bets.football.corners;

import com.savik.PeriodBet;
import com.savik.football.model.FootballPeriod;
import lombok.Getter;

@Getter
public class PeriodCornersTotalUnder extends PeriodBet<FootballPeriod> {

    private double amount;

    public PeriodCornersTotalUnder(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean canAnalyze(FootballPeriod period) {
        return period.hasCorners();
    }

    @Override
    public boolean check(FootballPeriod period) {
        return period.getCornersTotal() < amount;
    }
}