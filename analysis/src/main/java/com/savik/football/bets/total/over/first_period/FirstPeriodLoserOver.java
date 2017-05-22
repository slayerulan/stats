package com.savik.football.bets.total.over.first_period;

import com.savik.football.bets.GeneralBet;
import com.savik.football.model.Match;

public class FirstPeriodLoserOver extends GeneralBet {

    private double amount;

    public FirstPeriodLoserOver(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean canAnalyze(Match match) {
        return match.getBookieStats().hasFavorite() &&
               match.getMatchInfo().getFirstPeriod().getLoserScore(match.getBookieStats().getFavorite()) != null;
    }

    @Override
    public boolean check(Match match) {
        return match.getMatchInfo().getFirstPeriod().getLoserScore(match.getBookieStats().getFavorite()) > amount;
    }
}
