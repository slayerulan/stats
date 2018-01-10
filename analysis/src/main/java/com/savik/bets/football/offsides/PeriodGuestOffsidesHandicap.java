package com.savik.bets.football.offsides;

import com.savik.PeriodBet;
import com.savik.football.model.FootballPeriod;
import lombok.Getter;

@Getter
public class PeriodGuestOffsidesHandicap extends PeriodBet<FootballPeriod> {

    private double amount;

    public PeriodGuestOffsidesHandicap(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean canAnalyze(FootballPeriod period) {
        return period.hasOffsides();
    }

    @Override
    public boolean check(FootballPeriod period) {
        if (amount <= 0) {
            return period.getGuestOffsides() - period.getHomeOffsides() > Math.abs(amount);
        }
        return period.getHomeOffsides() - period.getGuestOffsides() < amount;
    }
}
