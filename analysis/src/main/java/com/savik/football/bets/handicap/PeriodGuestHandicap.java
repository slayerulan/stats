package com.savik.football.bets.handicap;

import com.savik.football.bets.PeriodBet;
import com.savik.football.model.FootballPeriod;
import lombok.*;

@Getter
public class PeriodGuestHandicap extends PeriodBet {

    private double amount;

    public PeriodGuestHandicap(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean canAnalyze(FootballPeriod period) {
        return period.hasScores();
    }

    @Override
    public boolean check(FootballPeriod period) {
        if (amount <= 0) {
            return period.getGuestScore() - period.getHomeScore() > Math.abs(amount);
        }
        return period.getHomeScore() - period.getGuestScore() < amount;
    }
}
