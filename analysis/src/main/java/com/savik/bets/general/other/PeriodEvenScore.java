package com.savik.bets.general.other;

import com.savik.Period;
import com.savik.PeriodBet;
import lombok.Getter;

@Getter
public class PeriodEvenScore extends PeriodBet {


    @Override
    public boolean canAnalyze(Period period) {
        return period.getTotalScore() != null;
    }

    @Override
    public boolean check(Period period) {
        return period.getTotalScore() % 2 == 0;
    }
}
