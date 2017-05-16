package com.savik.football.bets;

import com.savik.football.model.Match;

public abstract class GeneralBet {

    public abstract boolean canAnalyze(Match match);

    public abstract boolean check(Match match);
}
