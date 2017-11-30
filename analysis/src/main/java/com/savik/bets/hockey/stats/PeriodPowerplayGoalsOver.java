package com.savik.bets.hockey.stats;

import com.savik.PeriodBet;
import com.savik.hockey.model.HockeyPeriod;
import lombok.Getter;

@Getter
public class PeriodPowerplayGoalsOver extends PeriodBet<HockeyPeriod> {

    private double amount;

    public PeriodPowerplayGoalsOver(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean canAnalyze(HockeyPeriod period) {
        return period.getGuestPowerplayGoals() != null && period.getHomePowerplayGoals() != null;
    }

    @Override
    public boolean check(HockeyPeriod period) {
        return period.getGuestPowerplayGoals() + period.getHomePowerplayGoals() > amount;
    }
}
