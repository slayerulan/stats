package com.savik.football.bets;

import com.savik.Period;
import com.savik.Who;

public abstract class PeriodFavoriteBet {

    public abstract boolean canAnalyze(Who favorite, Period period);

    public abstract boolean check(Who favorite, Period period);
}
