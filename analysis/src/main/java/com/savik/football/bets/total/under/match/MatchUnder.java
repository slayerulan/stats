package com.savik.football.bets.total.under.match;

import com.savik.football.bets.GeneralBet;
import com.savik.football.model.Match;
import lombok.*;

@Getter
public class MatchUnder extends GeneralBet {
    private double amount;

    public MatchUnder(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean canAnalyze(Match match) {
        return match.getMatchInfo().getMatch().getTotalScore() != null;
    }

    @Override
    public boolean check(Match match) {
        return match.getMatchInfo().getMatch().getTotalScore() < amount;
    }
}
