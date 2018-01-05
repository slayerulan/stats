package com.savik.bets.hockey.stats;

import com.savik.PeriodBet;
import com.savik.hockey.model.HockeyPeriod;
import lombok.Getter;

@Getter
public class PeriodMinorPenaltiesTimeOver extends PeriodBet<HockeyPeriod> {

    private double amount;

    public PeriodMinorPenaltiesTimeOver(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean canAnalyze(HockeyPeriod period) {
        return period.getGuestMinorPenaltiesAmount() != null && period.getHomeMinorPenaltiesAmount() != null;
    }

    @Override
    public boolean check(HockeyPeriod period) {
        return (period.getGuestMinorPenaltiesAmount() + period.getHomeMinorPenaltiesAmount()) * 2 > amount;
    }
}
