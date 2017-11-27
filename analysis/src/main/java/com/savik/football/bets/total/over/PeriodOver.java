package com.savik.football.bets.total.over;

import com.savik.football.bets.PeriodBet;
import com.savik.football.model.FootballPeriod;
import lombok.*;

@Getter
public class PeriodOver extends PeriodBet {

    private double amount;

    public PeriodOver(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean canAnalyze(FootballPeriod period) {
        return period.getTotalScore() != null;
    }

    @Override
    public boolean check(FootballPeriod period) {
        return period.getTotalScore() > amount;
    }
}
