package com.savik.bets.hockey.stats;

import com.savik.PeriodBet;
import com.savik.hockey.model.HockeyPeriod;
import lombok.Getter;

@Getter
public class PeriodGuestShotsOnTargetOver extends PeriodBet<HockeyPeriod> {

    private double amount;

    public PeriodGuestShotsOnTargetOver(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean canAnalyze(HockeyPeriod period) {
        return period.getGuestShotsOnTarget() != null;
    }

    @Override
    public boolean check(HockeyPeriod period) {
        return period.getGuestShotsOnTarget() > amount;
    }
}
