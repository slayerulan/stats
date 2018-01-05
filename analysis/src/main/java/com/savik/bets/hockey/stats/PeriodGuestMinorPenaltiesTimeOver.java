package com.savik.bets.hockey.stats;

import com.savik.PeriodBet;
import com.savik.hockey.model.HockeyPeriod;
import lombok.Getter;

@Getter
public class PeriodGuestMinorPenaltiesTimeOver extends PeriodBet<HockeyPeriod> {

    private double amount;

    public PeriodGuestMinorPenaltiesTimeOver(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean canAnalyze(HockeyPeriod period) {
        return period.getGuestMinorPenaltiesAmount() != null;
    }

    @Override
    public boolean check(HockeyPeriod period) {
        return period.getGuestMinorPenaltiesAmount() * 2 > amount;
    }
}
