package com.savik.football.bets.total.over.first_period;

import com.savik.football.bets.GeneralBet;
import com.savik.football.model.Match;

public class FirstPeriodGuestOver extends GeneralBet {
    private double amount;

    public FirstPeriodGuestOver(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean canAnalyze(Match match) {
        return match.getMatchInfo().getFirstPeriod().getGuestScore() != null;
    }

    @Override
    public boolean check(Match match) {
        return match.getMatchInfo().getFirstPeriod().getGuestScore() > amount;
    }
}
