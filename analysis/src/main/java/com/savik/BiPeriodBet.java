package com.savik;


public class BiPeriodBet<T extends Period> extends PeriodBet<T> {


    private PeriodBet<T> first;
    private PeriodBet<T> second;

    public BiPeriodBet(PeriodBet<T> first, PeriodBet<T> second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean canAnalyze(T period) {
        return first.canAnalyze(period) && second.canAnalyze(period);
    }

    @Override
    public boolean check(T period) {
        return first.check(period) && second.check(period);
    }
}
