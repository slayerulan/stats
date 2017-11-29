package com.savik.football.bets.goals.match;

import com.savik.Period;
import com.savik.PeriodBet;
import lombok.*;

@Getter
public class LastGoalTimeAfter extends PeriodBet {

    double amount;

    public LastGoalTimeAfter(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean canAnalyze(Period period) {
        return period.getLastGoalTime() != null;
    }

    @Override
    public boolean check(Period period) {
        return period.getLastGoalTime() > amount;
    }
}
