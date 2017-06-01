package com.savik.football.bets.goals.match;

import com.savik.football.bets.GeneralBet;
import com.savik.football.bets.total.over.first_period.FirstPeriodLoserOver;
import com.savik.football.bets.total.over.second_period.SecondPeriodLoserOver;
import com.savik.football.model.FootballMatch;
import lombok.*;

@Getter
public class LoserScoredBothPeriods extends GeneralBet {

    private FirstPeriodLoserOver firstPeriodLoserOver;

    private SecondPeriodLoserOver secondPeriodLoserOver;

    public LoserScoredBothPeriods() {
        firstPeriodLoserOver = new FirstPeriodLoserOver(0);
        secondPeriodLoserOver = new SecondPeriodLoserOver(0);
    }

    @Override
    public boolean canAnalyze(FootballMatch footballMatch) {
        return firstPeriodLoserOver.canAnalyze(footballMatch) && secondPeriodLoserOver.canAnalyze(footballMatch);
    }

    @Override
    public boolean check(FootballMatch footballMatch) {
        return firstPeriodLoserOver.check(footballMatch) && secondPeriodLoserOver.check(footballMatch);
    }
}
