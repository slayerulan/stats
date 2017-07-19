package com.savik.football.bets.handicap;

import com.savik.football.bets.PeriodBet;
import com.savik.football.model.Period;
import lombok.*;

@Getter
public class PeriodHomeHandicap extends PeriodBet {

    private double amount;

    public PeriodHomeHandicap(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean canAnalyze(Period period) {
        return period.getHomeScore() != null && period.getGuestScore() != null;
    }

    @Override
    public boolean check(Period period) {
        if (amount <= 0) {
            return period.getHomeScore() - period.getGuestScore() > Math.abs(amount);
        }
        return period.getGuestScore() - period.getHomeScore() < amount;
    }
}
