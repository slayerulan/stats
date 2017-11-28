package com.savik.football.bets;

import com.savik.Match;

public abstract class GeneralBet<T extends Match> {

    public abstract boolean canAnalyze(T match);

    public abstract boolean check(T match);
}
