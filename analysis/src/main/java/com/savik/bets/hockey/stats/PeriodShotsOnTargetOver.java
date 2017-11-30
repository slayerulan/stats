package com.savik.bets.hockey.stats;

import com.savik.PeriodBet;
import com.savik.hockey.model.HockeyPeriod;
import lombok.Getter;

@Getter
public class PeriodShotsOnTargetOver extends PeriodBet<HockeyPeriod> {

    private double amount;

    public PeriodShotsOnTargetOver(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean canAnalyze(HockeyPeriod period) {
        return period.getGuestShotsOnTarget() != null && period.getHomeShotsOnTarget() != null;
    }

    @Override
    public boolean check(HockeyPeriod period) {
        return period.getGuestShotsOnTarget() + period.getHomeShotsOnTarget() > amount;
    }
}
