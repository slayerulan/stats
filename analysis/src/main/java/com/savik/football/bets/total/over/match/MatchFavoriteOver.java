package com.savik.football.bets.total.over.match;

import com.savik.football.bets.GeneralBet;
import com.savik.football.model.Match;

public class MatchFavoriteOver extends GeneralBet {

    private int amount;

    public MatchFavoriteOver(int amount) {
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
