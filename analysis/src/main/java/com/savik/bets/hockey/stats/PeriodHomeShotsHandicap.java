package com.savik.bets.hockey.stats;

import com.savik.PeriodBet;
import com.savik.hockey.model.HockeyPeriod;
import lombok.Getter;

@Getter
public class PeriodHomeShotsHandicap extends PeriodBet<HockeyPeriod> {

    private double amount;

    public PeriodHomeShotsHandicap(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean canAnalyze(HockeyPeriod period) {
        return period.getHomeShotsOnTarget() != null && period.getGuestShotsOnTarget() != null;
    }

    @Override
    public boolean check(HockeyPeriod period) {
        if (amount <= 0) {
            return period.getHomeShotsOnTarget() - period.getGuestShotsOnTarget() > Math.abs(amount);
        }
        return period.getGuestShotsOnTarget() - period.getHomeShotsOnTarget() < amount;
    }
}
