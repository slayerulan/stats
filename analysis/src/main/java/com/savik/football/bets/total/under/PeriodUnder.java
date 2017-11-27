package com.savik.football.bets.total.under;

import com.savik.football.bets.PeriodBet;
import com.savik.football.model.FootballPeriod;
import lombok.*;

@Getter
public class PeriodUnder extends PeriodBet {

    private double amount;

    public PeriodUnder(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean canAnalyze(FootballPeriod period) {
        return period.getTotalScore() != null;
    }

    @Override
    public boolean check(FootballPeriod period) {
        return period.getTotalScore() < amount;
    }
}
