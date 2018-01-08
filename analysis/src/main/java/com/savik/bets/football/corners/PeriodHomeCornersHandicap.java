package com.savik.bets.football.corners;

import com.savik.PeriodBet;
import com.savik.football.model.FootballPeriod;
import lombok.Getter;

@Getter
public class PeriodHomeCornersHandicap extends PeriodBet<FootballPeriod> {

    private double amount;

    public PeriodHomeCornersHandicap(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean canAnalyze(FootballPeriod period) {
        return period.hasCorners();
    }

    @Override
    public boolean check(FootballPeriod period) {
        if (amount <= 0) {
            return period.getHomeCorners() - period.getGuestCorners() > Math.abs(amount);
        }
        return period.getGuestCorners() - period.getHomeCorners() < amount;
    }
}
