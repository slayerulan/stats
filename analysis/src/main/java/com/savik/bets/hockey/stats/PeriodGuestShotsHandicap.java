package com.savik.bets.hockey.stats;

import com.savik.PeriodBet;
import com.savik.hockey.model.HockeyPeriod;
import lombok.Getter;

@Getter
public class PeriodGuestShotsHandicap extends PeriodBet<HockeyPeriod> {

    private double amount;

    public PeriodGuestShotsHandicap(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean canAnalyze(HockeyPeriod period) {
        return period.getHomeShotsOnTarget() != null && period.getGuestShotsOnTarget() != null;
    }

    @Override
    public boolean check(HockeyPeriod period) {
        if (amount <= 0) {
            return period.getGuestShotsOnTarget() - period.getHomeShotsOnTarget() > Math.abs(amount);
        }
        return period.getHomeShotsOnTarget() - period.getGuestShotsOnTarget() < amount;
    }
}
