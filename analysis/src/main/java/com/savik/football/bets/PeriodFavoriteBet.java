package com.savik.football.bets;

import com.savik.football.model.Period;
import com.savik.football.model.Who;

public abstract class PeriodFavoriteBet {

    public abstract boolean canAnalyze(Who favorite, Period period);

    public abstract boolean check(Who favorite, Period period);
}
