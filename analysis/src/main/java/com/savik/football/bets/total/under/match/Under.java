package com.savik.football.bets.total.under.match;

import com.savik.football.bets.GeneralBet;
import com.savik.football.model.Match;

public class Under extends GeneralBet {
    private int amount;

    public Under(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean canAnalyze(Match match) {
        return match.getMatchInfo().getMatch().getTotalScore() != null;
    }

    @Override
    public boolean match(Match match) {
        return match.getMatchInfo().getMatch().getTotalScore() < amount;
    }
}
