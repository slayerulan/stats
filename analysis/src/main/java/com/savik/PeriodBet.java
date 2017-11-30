package com.savik;

import com.savik.Period;

public abstract class PeriodBet<T extends Period> {

    public abstract boolean canAnalyze(T period);

    public abstract boolean check(T period);
}
