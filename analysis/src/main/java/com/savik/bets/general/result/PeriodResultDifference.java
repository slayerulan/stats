package com.savik.bets.general.result;

import com.savik.Period;
import com.savik.PeriodBet;
import lombok.Getter;

@Getter
public class PeriodResultDifference extends PeriodBet {

    private int diff;

    public PeriodResultDifference(int diff) {
        this.diff = diff;
    }

    @Override
    public boolean canAnalyze(Period period) {
        return period.hasScores();
    }

    @Override
    public boolean check(Period period) {
        return Math.abs(period.getGuestScore() - period.getHomeScore()) == diff;
    }
}
