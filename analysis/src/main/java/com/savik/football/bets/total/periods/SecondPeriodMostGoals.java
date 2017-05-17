package com.savik.football.bets.total.periods;

import com.savik.football.bets.GeneralBet;
import com.savik.football.model.Match;

public class SecondPeriodMostGoals extends GeneralBet {

    private int amount;

    public SecondPeriodMostGoals(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean canAnalyze(Match match) {
        return match.getMatchInfo().getFirstPeriod().getTotalScore() != null &&
               match.getMatchInfo().getSecondPeriod().getTotalScore() != null;
    }

    @Override
    public boolean check(Match match) {
        return match.getMatchInfo().getSecondPeriod().getTotalScore() >
               match.getMatchInfo().getFirstPeriod().getTotalScore();
    }
}
