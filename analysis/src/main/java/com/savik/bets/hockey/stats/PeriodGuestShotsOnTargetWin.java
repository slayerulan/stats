package com.savik.bets.hockey.stats;

import com.savik.PeriodBet;
import com.savik.hockey.model.HockeyPeriod;
import lombok.Getter;

@Getter
public class PeriodGuestShotsOnTargetWin extends PeriodBet<HockeyPeriod> {

    @Override
    public boolean canAnalyze(HockeyPeriod period) {
        return period.getHomeShotsOnTarget() != null && period.getGuestShotsOnTarget() != null;
    }

    @Override
    public boolean check(HockeyPeriod period) {
        return period.getGuestShotsOnTarget() > period.getHomeShotsOnTarget();
    }
}
