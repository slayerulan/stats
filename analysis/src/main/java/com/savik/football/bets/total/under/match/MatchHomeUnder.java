package com.savik.football.bets.total.under.match;

import com.savik.football.bets.GeneralBet;
import com.savik.football.model.Match;

public class MatchHomeUnder extends GeneralBet {
    private double amount;

    public MatchHomeUnder(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean canAnalyze(Match match) {
        return match.getMatchInfo().getMatch().getHomeScore() != null;
    }

    @Override
    public boolean check(Match match) {
        return match.getMatchInfo().getMatch().getHomeScore() < amount;
    }
}
