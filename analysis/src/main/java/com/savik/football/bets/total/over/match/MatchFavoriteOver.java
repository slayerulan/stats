package com.savik.football.bets.total.over.match;

import com.savik.football.bets.GeneralBet;
import com.savik.football.model.FootballMatch;
import lombok.*;

@Getter
public class MatchFavoriteOver extends GeneralBet {

    private double amount;

    public MatchFavoriteOver(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean canAnalyze(FootballMatch footballMatch) {
        return footballMatch.getBookieStats().hasFavorite() &&
               footballMatch
                       .getMatchInfo().getMatch().getFavoriteScore(footballMatch
                       .getBookieStats().getFavorite()) != null;
    }

    @Override
    public boolean check(FootballMatch footballMatch) {
        return footballMatch
                       .getMatchInfo().getMatch().getFavoriteScore(footballMatch
                        .getBookieStats().getFavorite()) > amount;
    }
}
