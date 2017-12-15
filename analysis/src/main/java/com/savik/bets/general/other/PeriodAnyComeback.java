package com.savik.bets.general.other;

import com.savik.*;
import lombok.Getter;

import java.util.Optional;

@Getter
public class PeriodAnyComeback extends PeriodBet {

    @Override
    public boolean canAnalyze(Period period) {
        Optional<Goal> goal = period.getGoal(Period.GoalOrder.FIRST);
        return goal.isPresent();
    }

    @Override
    public boolean check(Period period) {
        Goal goal = (Goal) period.getGoal(Period.GoalOrder.FIRST).get();
        if (goal.getWhoScored() == Who.HOME) {
            return period.getWinner() == Winner.GUEST;
        }
        return period.getWinner() == Winner.HOME;
    }
}
