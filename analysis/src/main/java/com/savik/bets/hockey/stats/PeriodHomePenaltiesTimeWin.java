package com.savik.bets.hockey.stats;

import com.savik.PeriodBet;
import com.savik.hockey.model.HockeyPeriod;
import lombok.Getter;

@Getter
public class PeriodHomePenaltiesTimeWin extends PeriodBet<HockeyPeriod> {

    @Override
    public boolean canAnalyze(HockeyPeriod period) {
        return period.getHomePenaltiesTime() != null && period.getGuestPenaltiesTime() != null;
    }

    @Override
    public boolean check(HockeyPeriod period) {
        return period.getHomePenaltiesTime() > period.getGuestPenaltiesTime();
    }
}
