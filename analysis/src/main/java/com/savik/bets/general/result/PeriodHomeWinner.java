package com.savik.bets.general.result;

import com.savik.Period;
import com.savik.PeriodBet;
import lombok.Getter;

@Getter
public class PeriodHomeWinner<T extends Period> extends PeriodBet<T> {

    @Override
    public boolean canAnalyze(Period period) {
        return period.hasScores();
    }

    @Override
    public boolean check(Period period) {
        return period.getHomeScore() > period.getGuestScore();
    }
}
