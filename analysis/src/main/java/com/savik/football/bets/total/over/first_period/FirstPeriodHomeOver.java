package com.savik.football.bets.total.over.first_period;

import com.savik.football.bets.GeneralBet;
import com.savik.football.model.Match;

public class FirstPeriodHomeOver extends GeneralBet {
    private int amount;

    public FirstPeriodHomeOver(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean canAnalyze(Match match) {
        return match.getMatchInfo().getFirstPeriod().getHomeScore() != null;
    }

    @Override
    public boolean check(Match match) {
        return match.getMatchInfo().getFirstPeriod().getHomeScore() > amount;
    }
}
