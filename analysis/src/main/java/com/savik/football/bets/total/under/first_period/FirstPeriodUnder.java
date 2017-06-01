package com.savik.football.bets.total.under.first_period;

import com.savik.football.bets.GeneralBet;
import com.savik.football.model.FootballMatch;
import lombok.*;

@Getter
public class FirstPeriodUnder extends GeneralBet {
    private double amount;

    public FirstPeriodUnder(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean canAnalyze(FootballMatch footballMatch) {
        return footballMatch.getMatchInfo().getFirstPeriod().getTotalScore() != null;
    }

    @Override
    public boolean check(FootballMatch footballMatch) {
        return footballMatch.getMatchInfo().getFirstPeriod().getTotalScore() < amount;
    }
}
