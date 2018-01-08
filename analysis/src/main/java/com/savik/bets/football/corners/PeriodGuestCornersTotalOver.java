package com.savik.bets.football.corners;

import com.savik.PeriodBet;
import com.savik.football.model.FootballPeriod;
import lombok.Getter;

@Getter
public class PeriodGuestCornersTotalOver extends PeriodBet<FootballPeriod> {

    private double amount;

    public PeriodGuestCornersTotalOver(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean canAnalyze(FootballPeriod period) {
        return period.getGuestCorners() != null;
    }

    @Override
    public boolean check(FootballPeriod period) {
        return period.getGuestCorners() > amount;
    }
}
