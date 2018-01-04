package com.savik.bets.general.goals;

import com.savik.Period;
import com.savik.PeriodBet;
import lombok.Getter;

@Getter
public class PeriodGoalTimeBetween extends PeriodBet {

    int from;
    int to;

    public PeriodGoalTimeBetween(int from, int to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public boolean canAnalyze(Period period) {
        return period.getGoals() != null;
    }

    @Override
    public boolean check(Period period) {
        return period.hasGoalBetweenFromPeriodStart(from, to);
    }
}
