package com.savik.football.bets;

import com.savik.football.model.Match;

public class OverInMatch extends GeneralBet {
    private int amount;

    public OverInMatch(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean canAnalize(Match match) {
        return match.getMatchInfo().getMatch().getTotalScore() != null;
    }

    @Override
    public boolean match(Match match) {
        return match.getMatchInfo().getMatch().getTotalScore() > amount;
    }
}
