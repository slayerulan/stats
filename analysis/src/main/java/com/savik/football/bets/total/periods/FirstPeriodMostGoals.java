package com.savik.football.bets.total.periods;

import com.savik.football.bets.GeneralBet;
import com.savik.football.model.FootballMatch;
import lombok.*;

@Getter
public class FirstPeriodMostGoals extends GeneralBet {


    public FirstPeriodMostGoals() {
    }

    @Override
    public boolean canAnalyze(FootballMatch footballMatch) {
        return footballMatch.getMatchInfo().getFirstPeriod().getTotalScore() != null &&
               footballMatch.getMatchInfo().getSecondPeriod().getTotalScore() != null;
    }

    @Override
    public boolean check(FootballMatch footballMatch) {
        return footballMatch.getMatchInfo().getFirstPeriod().getTotalScore() >
               footballMatch.getMatchInfo().getSecondPeriod().getTotalScore();
    }
}
