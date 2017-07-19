package com.savik.football.bets.total.over;

import com.savik.football.bets.PeriodBet;
import com.savik.football.model.Period;
import lombok.*;

@Getter
public class PeriodGuestOver extends PeriodBet {

    private double amount;

    public PeriodGuestOver(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean canAnalyze(Period period) {
        return period.getGuestScore() != null;
    }

    @Override
    public boolean check(Period period) {
        return period.getGuestScore() > amount;
    }
}
