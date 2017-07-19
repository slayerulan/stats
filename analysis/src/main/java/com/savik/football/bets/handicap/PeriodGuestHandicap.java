package com.savik.football.bets.handicap;

import com.savik.football.bets.PeriodBet;
import com.savik.football.model.Period;
import lombok.*;

@Getter
public class PeriodGuestHandicap extends PeriodBet {

    private double amount;

    public PeriodGuestHandicap(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean canAnalyze(Period period) {
        return period.getGuestScore() != null && period.getHomeScore() != null;
    }

    @Override
    public boolean check(Period period) {
        if (amount <= 0) {
            return period.getGuestScore() - period.getHomeScore() > Math.abs(amount);
        }
        return period.getHomeScore() - period.getGuestScore() < amount;
    }
}
