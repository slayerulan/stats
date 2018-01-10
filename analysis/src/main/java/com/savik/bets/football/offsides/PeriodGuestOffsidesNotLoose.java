package com.savik.bets.football.offsides;

import com.savik.PeriodBet;
import com.savik.football.model.FootballPeriod;
import lombok.Getter;

@Getter
public class PeriodGuestOffsidesNotLoose extends PeriodBet<FootballPeriod> {

    @Override
    public boolean canAnalyze(FootballPeriod period) {
        return period.hasOffsides();
    }

    @Override
    public boolean check(FootballPeriod period) {
        return period.getGuestOffsides() >= period.getHomeOffsides();
    }
}
