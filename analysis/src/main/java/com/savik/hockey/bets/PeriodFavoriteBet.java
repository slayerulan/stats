package com.savik.hockey.bets;

import com.savik.Who;
import com.savik.hockey.model.HockeyPeriod;

public abstract class PeriodFavoriteBet {

    public abstract boolean canAnalyze(Who favorite, HockeyPeriod period);

    public abstract boolean check(Who favorite, HockeyPeriod period);
}
