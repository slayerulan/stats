package com.savik.football.bets;

import com.savik.football.model.FootballPeriod;

public abstract class PeriodBet {

    public abstract boolean canAnalyze(FootballPeriod period);

    public abstract boolean check(FootballPeriod period);
}
