package com.savik.hockey.bets.total.over;


import com.savik.hockey.bets.PeriodBet;
import com.savik.hockey.model.HockeyPeriod;

public class PeriodOver extends PeriodBet {

    private double amount;

    @Override
    public boolean canAnalyze(HockeyPeriod period) {
        return period.getTotalScore() != null;
    }

    @Override
    public boolean check(HockeyPeriod period) {
        return period.getTotalScore() > amount;
    }
}