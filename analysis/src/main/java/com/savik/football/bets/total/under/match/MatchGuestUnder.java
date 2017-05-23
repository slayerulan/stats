package com.savik.football.bets.total.under.match;

import com.savik.football.bets.GeneralBet;
import com.savik.football.model.Match;
import lombok.*;

@Getter
public class MatchGuestUnder extends GeneralBet {
    private double amount;

    public MatchGuestUnder(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean canAnalyze(Match match) {
        return match.getMatchInfo().getMatch().getGuestScore() != null;
    }

    @Override
    public boolean check(Match match) {
        return match.getMatchInfo().getMatch().getGuestScore() < amount;
    }
}
