package com.savik.bets.hockey.stats;

import com.savik.PeriodBet;
import com.savik.hockey.model.HockeyPeriod;
import lombok.Getter;

@Getter
public class PeriodHomeMinorPenaltiesTimeOver extends PeriodBet<HockeyPeriod> {

    private double amount;

    public PeriodHomeMinorPenaltiesTimeOver(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean canAnalyze(HockeyPeriod period) {
        return period.getHomeMinorPenaltiesAmount() != null;
    }

    @Override
    public boolean check(HockeyPeriod period) {
        return period.getHomeMinorPenaltiesAmount() * 2 > amount;
    }
}
