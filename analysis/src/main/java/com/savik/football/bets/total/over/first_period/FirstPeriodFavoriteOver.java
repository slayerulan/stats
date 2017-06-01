package com.savik.football.bets.total.over.first_period;

import com.savik.football.bets.GeneralBet;
import com.savik.football.model.FootballMatch;
import lombok.*;

@Getter
public class FirstPeriodFavoriteOver extends GeneralBet {

    private double amount;

    public FirstPeriodFavoriteOver(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean canAnalyze(FootballMatch footballMatch) {
        return footballMatch.getBookieStats().hasFavorite() &&
               footballMatch
                       .getMatchInfo().getFirstPeriod().getFavoriteScore(footballMatch
                       .getBookieStats().getFavorite()) != null;
    }

    @Override
    public boolean check(FootballMatch footballMatch) {
        return footballMatch
                       .getMatchInfo().getFirstPeriod().getFavoriteScore(footballMatch
                        .getBookieStats().getFavorite()) > amount;
    }
}
