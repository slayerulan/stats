package com.savik.football.bets.total.under.second_period;

import com.savik.football.bets.GeneralBet;
import com.savik.football.model.Match;

public class SecondPeriodUnder extends GeneralBet {
    private double amount;

    public SecondPeriodUnder(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean canAnalyze(Match match) {
        return match.getMatchInfo().getSecondPeriod().getTotalScore() != null;
    }

    @Override
    public boolean check(Match match) {
        return match.getMatchInfo().getSecondPeriod().getTotalScore() < amount;
    }
}
