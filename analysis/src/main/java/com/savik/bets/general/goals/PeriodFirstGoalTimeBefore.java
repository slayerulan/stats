package com.savik.bets.general.goals;

import com.savik.Period;
import com.savik.PeriodBet;
import lombok.Getter;

@Getter
public class PeriodFirstGoalTimeBefore extends PeriodBet {

    int amount;

    public PeriodFirstGoalTimeBefore(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean canAnalyze(Period period) {
        return period.getFirstGoalTime() != null;
    }

    @Override
    public boolean check(Period period) {
        return period.getFirstGoalTime() < amount;
    }
}
