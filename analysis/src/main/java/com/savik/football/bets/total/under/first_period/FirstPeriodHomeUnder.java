package com.savik.football.bets.total.under.first_period;

import com.savik.football.bets.GeneralBet;
import com.savik.football.model.Match;

public class FirstPeriodHomeUnder extends GeneralBet {
    private double amount;

    public FirstPeriodHomeUnder(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean canAnalyze(Match match) {
        return match.getMatchInfo().getFirstPeriod().getHomeScore() != null;
    }

    @Override
    public boolean check(Match match) {
        return match.getMatchInfo().getFirstPeriod().getHomeScore() < amount;
    }
}
