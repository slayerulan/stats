package com.savik.football.bets.total.under.first_period;

import com.savik.football.bets.GeneralBet;
import com.savik.football.model.Match;
import lombok.*;

@Getter
public class FirstPeriodGuestUnder extends GeneralBet {
    private double amount;

    public FirstPeriodGuestUnder(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean canAnalyze(Match match) {
        return match.getMatchInfo().getFirstPeriod().getGuestScore() != null;
    }

    @Override
    public boolean check(Match match) {
        return match.getMatchInfo().getFirstPeriod().getGuestScore() < amount;
    }
}
