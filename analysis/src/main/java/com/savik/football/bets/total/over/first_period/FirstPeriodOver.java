package com.savik.football.bets.total.over.first_period;

import com.savik.football.bets.GeneralBet;
import com.savik.football.model.Match;

public class FirstPeriodOver extends GeneralBet {
    private int amount;

    public FirstPeriodOver(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean canAnalyze(Match match) {
        return match.getMatchInfo().getFirstPeriod().getTotalScore() != null;
    }

    @Override
    public boolean check(Match match) {
        return match.getMatchInfo().getFirstPeriod().getTotalScore() > amount;
    }
}
