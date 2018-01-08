package com.savik.bets.hockey.stats;

import com.savik.PeriodBet;
import com.savik.hockey.model.HockeyPeriod;
import lombok.Getter;

@Getter
public class PeriodHomeMinorPenaltiesTimeNotLoose extends PeriodBet<HockeyPeriod> {

    @Override
    public boolean canAnalyze(HockeyPeriod period) {
        return period.getHomeMinorPenaltiesAmount() != null && period.getGuestMinorPenaltiesAmount() != null;
    }

    @Override
    public boolean check(HockeyPeriod period) {
        return period.getHomeMinorPenaltiesAmount() >= period.getGuestMinorPenaltiesAmount();
    }
}