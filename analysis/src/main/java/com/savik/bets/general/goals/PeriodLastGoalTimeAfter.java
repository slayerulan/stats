package com.savik.bets.general.goals;

import com.savik.Period;
import com.savik.PeriodBet;
import lombok.*;

@Getter
public class PeriodLastGoalTimeAfter extends PeriodBet {

    double amount;

    public PeriodLastGoalTimeAfter(double amount) {
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
