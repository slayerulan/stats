package com.savik.football.bets.handicap.match;

import com.savik.football.bets.GeneralBet;
import com.savik.football.model.Match;
import com.savik.football.model.Period;

/**
 * @author Savushkin Yauheni
 * @since 17.05.2017
 */
public class MatchFavoriteHandicap extends GeneralBet {

    private int amount;

    public MatchFavoriteHandicap(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean canAnalyze(Match match) {
        return match.getBookieStats().hasFavorite() &&
               match.getMatchInfo().getMatch().getHomeScore() != null &&
               match.getMatchInfo().getMatch().getGuestScore() != null;
    }

    @Override
    public boolean check(Match match) {



/*
        Period matchInfo = match.getMatchInfo().getMatch();
        if (amount <= 0) {
            return (matchInfo.getGuestScore() - matchInfo.getHomeScore()) > Math.abs(amount);
        }
        return (matchInfo.getHomeScore() - matchInfo.getGuestScore()) < amount;*/
    }
}
