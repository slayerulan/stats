package com.savik.hockey.bets;

import com.savik.hockey.model.HockeyPeriod;

public abstract class PeriodBet {

    public abstract boolean canAnalyze(HockeyPeriod period);

    public abstract boolean check(HockeyPeriod period);
}
