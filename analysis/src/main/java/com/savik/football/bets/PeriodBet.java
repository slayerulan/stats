package com.savik.football.bets;

import com.savik.football.model.Period;

public abstract class PeriodBet {

    public abstract boolean canAnalyze(Period period);

    public abstract boolean check(Period period);
}
