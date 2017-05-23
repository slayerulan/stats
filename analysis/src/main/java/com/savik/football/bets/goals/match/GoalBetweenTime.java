package com.savik.football.bets.goals.match;

import com.savik.football.bets.GeneralBet;
import com.savik.football.model.Match;
import lombok.*;

@Getter
public class GoalBetweenTime extends GeneralBet {

    int from, before;

    public GoalBetweenTime(int from, int before) {
        this.from = from;
        this.before = before;
    }

    @Override
    public boolean canAnalyze(Match match) {
        return match.getMatchInfo().getMatch().getGoals() != null;
    }

    @Override
    public boolean check(Match match) {
        return match.getMatchInfo().getMatch().hasGoalBetween(from, before);
    }
}
