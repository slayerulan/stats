package com.savik.football.bets.handicap;

import com.savik.football.bets.PeriodBet;
import com.savik.football.model.FootballPeriod;
import lombok.*;

@Getter
public class PeriodHomeHandicap extends PeriodBet {

    private double amount;

    public PeriodHomeHandicap(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean canAnalyze(FootballPeriod period) {
        return period.hasScores();
    }

    @Override
    public boolean check(FootballPeriod period) {
        if (amount <= 0) {
            return period.getHomeScore() - period.getGuestScore() > Math.abs(amount);
        }
        return period.getGuestScore() - period.getHomeScore() < amount;
    }
}
