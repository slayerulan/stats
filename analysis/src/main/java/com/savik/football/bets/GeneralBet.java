package com.savik.football.bets;

import com.savik.football.model.Match;

public abstract class GeneralBet {
    public abstract boolean canAnalize(Match match);
    public abstract boolean match(Match match);
}
