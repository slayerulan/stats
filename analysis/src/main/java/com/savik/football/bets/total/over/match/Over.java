package com.savik.football.bets.total.over.match;

import com.savik.football.bets.GeneralBet;
import com.savik.football.model.Match;

public class Over extends GeneralBet {
    private int amount;

    public Over(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean canAnalyze(Match match) {
        return match.getMatchInfo().getMatch().getTotalScore() != null;
    }

    @Override
    public boolean match(Match match) {
        return match.getMatchInfo().getMatch().getTotalScore() > amount;
    }
}
