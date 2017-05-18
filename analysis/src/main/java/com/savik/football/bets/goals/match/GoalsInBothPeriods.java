package com.savik.football.bets.goals.match;

import com.savik.football.bets.GeneralBet;
import com.savik.football.bets.total.over.first_period.FirstPeriodOver;
import com.savik.football.bets.total.over.second_period.SecondPeriodOver;
import com.savik.football.model.Match;

public class GoalsInBothPeriods extends GeneralBet {

    private FirstPeriodOver firstPeriodOver;

    private SecondPeriodOver secondPeriodOver;

    public GoalsInBothPeriods() {
        firstPeriodOver = new FirstPeriodOver(0);
        secondPeriodOver = new SecondPeriodOver(0);
    }

    @Override
    public boolean canAnalyze(Match match) {
        return firstPeriodOver.canAnalyze(match) && secondPeriodOver.canAnalyze(match);
    }

    @Override
    public boolean check(Match match) {
        return firstPeriodOver.check(match) && secondPeriodOver.check(match);
    }
}
