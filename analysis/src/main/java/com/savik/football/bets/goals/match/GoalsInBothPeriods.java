package com.savik.football.bets.goals.match;

import com.savik.football.bets.GeneralBet;
import com.savik.football.bets.total.over.first_period.FirstPeriodOver;
import com.savik.football.bets.total.over.second_period.SecondPeriodOver;
import com.savik.football.model.FootballMatch;
import lombok.*;

@Getter
public class GoalsInBothPeriods extends GeneralBet {

    private FirstPeriodOver firstPeriodOver;

    private SecondPeriodOver secondPeriodOver;

    public GoalsInBothPeriods() {
        firstPeriodOver = new FirstPeriodOver(0);
        secondPeriodOver = new SecondPeriodOver(0);
    }

    @Override
    public boolean canAnalyze(FootballMatch footballMatch) {
        return firstPeriodOver.canAnalyze(footballMatch) && secondPeriodOver.canAnalyze(footballMatch);
    }

    @Override
    public boolean check(FootballMatch footballMatch) {
        return firstPeriodOver.check(footballMatch) && secondPeriodOver.check(footballMatch);
    }
}
