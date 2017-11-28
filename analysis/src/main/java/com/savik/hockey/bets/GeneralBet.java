package com.savik.hockey.bets;

import com.savik.hockey.model.HockeyMatch;

public abstract class GeneralBet {

    public abstract boolean canAnalyze(HockeyMatch footballMatch);

    public abstract boolean check(HockeyMatch footballMatch);
}
