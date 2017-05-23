package com.savik.football.bets.goals.match;

import com.savik.football.bets.GeneralBet;
import com.savik.football.model.Match;
import lombok.*;

@Getter
public class FirstGoalTimeBefore extends GeneralBet {

    double amount;

    public FirstGoalTimeBefore(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean canAnalyze(Match match) {
        return match.getMatchInfo().getMatch().getFirstGoalTime() != null;
    }

    @Override
    public boolean check(Match match) {
        return match.getMatchInfo().getMatch().getFirstGoalTime() < amount;
    }
}
