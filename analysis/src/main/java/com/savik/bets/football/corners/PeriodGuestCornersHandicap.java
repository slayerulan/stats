package com.savik.bets.football.corners;

import com.savik.PeriodBet;
import com.savik.football.model.FootballPeriod;
import lombok.Getter;

@Getter
public class PeriodGuestCornersHandicap extends PeriodBet<FootballPeriod> {

    private double amount;

    public PeriodGuestCornersHandicap(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean canAnalyze(FootballPeriod period) {
        return period.hasCorners();
    }

    @Override
    public boolean check(FootballPeriod period) {
        if (amount <= 0) {
            return period.getGuestCorners() - period.getHomeCorners() > Math.abs(amount);
        }
        return period.getHomeCorners() - period.getGuestCorners() < amount;
    }
}