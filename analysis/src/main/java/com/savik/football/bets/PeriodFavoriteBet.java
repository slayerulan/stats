package com.savik.football.bets;

import com.savik.football.model.FootballPeriod;
import com.savik.football.model.Who;

public abstract class PeriodFavoriteBet {

    public abstract boolean canAnalyze(Who favorite, FootballPeriod period);

    public abstract boolean check(Who favorite, FootballPeriod period);
}
