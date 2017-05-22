package com.savik.football.bets.total.over.match;

import com.savik.football.bets.GeneralBet;
import com.savik.football.model.Match;

public class MatchHomeOver extends GeneralBet {
    private double amount;

    public MatchHomeOver(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean canAnalyze(Match match) {
        return match.getMatchInfo().getMatch().getHomeScore() != null;
    }

    @Override
    public boolean check(Match match) {
        return match.getMatchInfo().getMatch().getHomeScore() > amount;
    }
}
