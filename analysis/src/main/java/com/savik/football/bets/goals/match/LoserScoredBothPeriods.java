package com.savik.football.bets.goals.match;

import com.savik.football.bets.GeneralBet;
import com.savik.football.bets.total.over.first_period.FirstPeriodLoserOver;
import com.savik.football.bets.total.over.second_period.SecondPeriodLoserOver;
import com.savik.football.model.Match;
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
    public boolean canAnalyze(Match match) {
        return firstPeriodLoserOver.canAnalyze(match) && secondPeriodLoserOver.canAnalyze(match);
    }

    @Override
    public boolean check(Match match) {
        return firstPeriodLoserOver.check(match) && secondPeriodLoserOver.check(match);
    }
}
