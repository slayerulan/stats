package com.savik.football.bets.goals.match;

import com.savik.Period;
import com.savik.football.bets.GeneralBet;
import com.savik.football.bets.PeriodBet;
import com.savik.football.model.FootballMatch;
import lombok.*;

@Getter
public class PeriodFirstGoalTimeBefore extends PeriodBet {

    double amount;

    public PeriodFirstGoalTimeBefore(double amount) {
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
