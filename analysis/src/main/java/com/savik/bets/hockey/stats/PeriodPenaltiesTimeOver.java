package com.savik.bets.hockey.stats;

import com.savik.PeriodBet;
import com.savik.hockey.model.HockeyPeriod;
import lombok.Getter;

@Getter
public class PeriodPenaltiesTimeOver extends PeriodBet<HockeyPeriod> {

    private double amount;

    public PeriodPenaltiesTimeOver(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean canAnalyze(HockeyPeriod period) {
        return period.getGuestPenaltiesTime() != null && period.getHomePenaltiesTime() != null;
    }

    @Override
    public boolean check(HockeyPeriod period) {
        return period.getGuestPenaltiesTime() + period.getHomePenaltiesTime() > amount;
    }
}
