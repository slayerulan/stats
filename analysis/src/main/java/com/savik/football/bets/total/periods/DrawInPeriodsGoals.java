package com.savik.football.bets.total.periods;

import java.util.Objects;

import com.savik.football.bets.GeneralBet;
import com.savik.football.model.Match;

public class DrawInPeriodsGoals extends GeneralBet {


    public DrawInPeriodsGoals() {
    }

    @Override
    public boolean canAnalyze(Match match) {
        return match.getMatchInfo().getFirstPeriod().getTotalScore() != null &&
               match.getMatchInfo().getSecondPeriod().getTotalScore() != null;
    }

    @Override
    public boolean check(Match match) {
        return Objects.equals(
                match.getMatchInfo().getSecondPeriod().getTotalScore(),
                match.getMatchInfo().getFirstPeriod().getTotalScore()
        );
    }
}
