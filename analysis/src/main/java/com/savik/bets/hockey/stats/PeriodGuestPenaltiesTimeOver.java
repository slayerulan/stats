package com.savik.bets.hockey.stats;

import com.savik.PeriodBet;
import com.savik.hockey.model.HockeyPeriod;
import lombok.Getter;

@Getter
public class PeriodGuestPenaltiesTimeOver extends PeriodBet<HockeyPeriod> {

    private double amount;

    public PeriodGuestPenaltiesTimeOver(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean canAnalyze(HockeyPeriod period) {
        return period.getGuestPenaltiesTime() != null;
    }

    @Override
    public boolean check(HockeyPeriod period) {
        return period.getGuestPenaltiesTime() > amount;
    }
}
