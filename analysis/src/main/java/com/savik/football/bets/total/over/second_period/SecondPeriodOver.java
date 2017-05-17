package com.savik.football.bets.total.over.second_period;

import com.savik.football.bets.GeneralBet;
import com.savik.football.model.Match;

public class SecondPeriodOver extends GeneralBet {
    private int amount;

    public SecondPeriodOver(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean canAnalyze(Match match) {
        return match.getMatchInfo().getSecondPeriod().getTotalScore() != null;
    }

    @Override
    public boolean check(Match match) {
        return match.getMatchInfo().getSecondPeriod().getTotalScore() > amount;
    }
}
