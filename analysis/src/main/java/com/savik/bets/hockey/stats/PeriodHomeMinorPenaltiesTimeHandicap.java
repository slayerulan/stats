package com.savik.bets.hockey.stats;

import com.savik.PeriodBet;
import com.savik.hockey.model.HockeyPeriod;
import lombok.Getter;

@Getter
public class PeriodHomeMinorPenaltiesTimeHandicap extends PeriodBet<HockeyPeriod> {

    private double amount;

    public PeriodHomeMinorPenaltiesTimeHandicap(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean canAnalyze(HockeyPeriod period) {
        return period.getGuestMinorPenaltiesAmount() != null && period.getHomeMinorPenaltiesAmount() != null;
    }

    @Override
    public boolean check(HockeyPeriod period) {
        if (amount <= 0) {
            return (period.getHomeMinorPenaltiesAmount() - period.getGuestMinorPenaltiesAmount()) * 2 > Math.abs(amount);
        }
        return (period.getGuestMinorPenaltiesAmount() - period.getHomeMinorPenaltiesAmount()) * 2 < amount;
    }
}
