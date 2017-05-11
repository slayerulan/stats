package com.savik.football.bets.total.over.match;

import com.savik.football.bets.GeneralBet;
import com.savik.football.model.Match;

public class HomeOver extends GeneralBet {
    private int amount;

    public HomeOver(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean canAnalyze(Match match) {
        return match.getMatchInfo().getMatch().getHomeScore() != null;
    }

    @Override
    public boolean match(Match match) {
        return match.getMatchInfo().getMatch().getHomeScore() > amount;
    }
}
