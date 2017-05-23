package com.savik.football.bets.total.over.match;

import com.savik.football.bets.GeneralBet;
import com.savik.football.model.Match;
import lombok.*;

@Getter
public class MatchFavoriteOver extends GeneralBet {

    private double amount;

    public MatchFavoriteOver(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean canAnalyze(Match match) {
        return match.getBookieStats().hasFavorite() &&
               match.getMatchInfo().getMatch().getFavoriteScore(match.getBookieStats().getFavorite()) != null;
    }

    @Override
    public boolean check(Match match) {
        return match.getMatchInfo().getMatch().getFavoriteScore(match.getBookieStats().getFavorite()) > amount;
    }
}
