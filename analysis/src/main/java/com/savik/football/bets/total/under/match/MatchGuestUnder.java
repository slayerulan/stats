package com.savik.football.bets.total.under.match;

import com.savik.football.bets.GeneralBet;
import com.savik.football.model.FootballMatch;
import lombok.*;

@Getter
public class MatchGuestUnder extends GeneralBet {
    private double amount;

    public MatchGuestUnder(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean canAnalyze(FootballMatch footballMatch) {
        return footballMatch.getMatchInfo().getMatch().getGuestScore() != null;
    }

    @Override
    public boolean check(FootballMatch footballMatch) {
        return footballMatch.getMatchInfo().getMatch().getGuestScore() < amount;
    }
}
