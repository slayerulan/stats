package com.savik.bets.hockey.stats;

import com.savik.PeriodBet;
import com.savik.hockey.model.HockeyPeriod;
import lombok.Getter;

@Getter
public class PeriodHomeShotsOnTargetOver extends PeriodBet<HockeyPeriod> {

    private double amount;

    public PeriodHomeShotsOnTargetOver(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean canAnalyze(HockeyPeriod period) {
        return period.getHomeShotsOnTarget() != null;
    }

    @Override
    public boolean check(HockeyPeriod period) {
        return period.getHomeShotsOnTarget() > amount;
    }
}
