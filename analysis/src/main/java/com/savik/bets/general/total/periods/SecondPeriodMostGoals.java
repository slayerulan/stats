package com.savik.bets.general.total.periods;

import com.savik.GeneralBet;
import com.savik.football.model.FootballMatch;
import lombok.*;

@Getter
public class SecondPeriodMostGoals extends GeneralBet<FootballMatch> {


    public SecondPeriodMostGoals() {
    }

    @Override
    public boolean canAnalyze(FootballMatch footballMatch) {
        return footballMatch.getMatchInfo().getFirstPeriod().getTotalScore() != null &&
               footballMatch.getMatchInfo().getSecondPeriod().getTotalScore() != null;
    }

    @Override
    public boolean check(FootballMatch footballMatch) {
        return footballMatch.getMatchInfo().getSecondPeriod().getTotalScore() >
               footballMatch.getMatchInfo().getFirstPeriod().getTotalScore();
    }
}
