package com.savik.bets.football.corners;

import com.savik.PeriodBet;
import com.savik.football.model.FootballPeriod;
import lombok.Getter;

@Getter
public class PeriodHomeCornersNotLoose extends PeriodBet<FootballPeriod> {


    @Override
    public boolean canAnalyze(FootballPeriod period) {
        return period.hasCorners();
    }

    @Override
    public boolean check(FootballPeriod period) {
        return period.getHomeCorners() >= period.getGuestCorners();
    }
}
