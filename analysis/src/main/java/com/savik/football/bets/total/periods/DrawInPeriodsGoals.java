package com.savik.football.bets.total.periods;

import java.util.Objects;

import com.savik.football.bets.GeneralBet;
import com.savik.football.model.FootballMatch;
import lombok.*;

@Getter
public class DrawInPeriodsGoals extends GeneralBet {


    public DrawInPeriodsGoals() {
    }

    @Override
    public boolean canAnalyze(FootballMatch footballMatch) {
        return footballMatch.getMatchInfo().getFirstPeriod().getTotalScore() != null &&
               footballMatch.getMatchInfo().getSecondPeriod().getTotalScore() != null;
    }

    @Override
    public boolean check(FootballMatch footballMatch) {
        return Objects.equals(
                footballMatch.getMatchInfo().getSecondPeriod().getTotalScore(),
                footballMatch.getMatchInfo().getFirstPeriod().getTotalScore()
        );
    }
}
