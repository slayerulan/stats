package com.savik.bets.hockey.stats;

import com.savik.PeriodBet;
import com.savik.hockey.model.HockeyPeriod;
import lombok.Getter;

@Getter
public class PeriodHomePenaltiesTimeOver extends PeriodBet<HockeyPeriod> {

    private double amount;

    public PeriodHomePenaltiesTimeOver(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean canAnalyze(HockeyPeriod period) {
        return period.getHomePenaltiesTime() != null;
    }

    @Override
    public boolean check(HockeyPeriod period) {
        return period.getHomePenaltiesTime() > amount;
    }
}
