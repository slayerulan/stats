package com.savik.football.bets.goals.match;

import com.savik.football.bets.GeneralBet;
import com.savik.football.model.Match;
import lombok.*;

@Getter
public class LastGoalTimeAfter extends GeneralBet {

    double amount;

    public LastGoalTimeAfter(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean canAnalyze(Match match) {
        return match.getMatchInfo().getMatch().getLastGoalTime() != null;
    }

    @Override
    public boolean check(Match match) {
        return match.getMatchInfo().getMatch().getLastGoalTime() > amount;
    }
}
