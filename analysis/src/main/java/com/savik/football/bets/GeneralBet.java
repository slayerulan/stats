package com.savik.football.bets;

import com.savik.football.model.FootballMatch;

public abstract class GeneralBet {

    public abstract boolean canAnalyze(FootballMatch footballMatch);

    public abstract boolean check(FootballMatch footballMatch);
}
