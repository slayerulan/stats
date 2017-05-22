package com.savik.football.bets.total.under.second_period;

import com.savik.football.bets.GeneralBet;
import com.savik.football.model.Match;

public class SecondPeriodHomeUnder extends GeneralBet {
    private double amount;

    public SecondPeriodHomeUnder(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean canAnalyze(Match match) {
        return match.getMatchInfo().getSecondPeriod().getHomeScore() != null;
    }

    @Override
    public boolean check(Match match) {
        return match.getMatchInfo().getSecondPeriod().getHomeScore() < amount;
    }
}
