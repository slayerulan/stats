package com.savik.football.bets.total.under;

import com.savik.football.bets.PeriodBet;
import com.savik.football.model.FootballPeriod;
import lombok.*;

@Getter
public class PeriodHomeUnder extends PeriodBet {

    private double amount;

    public PeriodHomeUnder(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean canAnalyze(FootballPeriod period) {
        return period.getHomeScore() != null;
    }

    @Override
    public boolean check(FootballPeriod period) {
        return period.getHomeScore() < amount;
    }
}
