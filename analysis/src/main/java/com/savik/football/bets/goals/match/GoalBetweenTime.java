package com.savik.football.bets.goals.match;

import com.savik.football.bets.GeneralBet;
import com.savik.football.model.FootballMatch;
import lombok.*;

@Getter
public class GoalBetweenTime extends GeneralBet<FootballMatch> {

    int from, before;

    public GoalBetweenTime(int from, int before) {
        this.from = from;
        this.before = before;
    }

    @Override
    public boolean canAnalyze(FootballMatch footballMatch) {
        return footballMatch.getMatchInfo().getMatch().getGoals() != null;
    }

    @Override
    public boolean check(FootballMatch footballMatch) {
        return footballMatch.getMatchInfo().getMatch().hasGoalBetween(from, before);
    }
}
