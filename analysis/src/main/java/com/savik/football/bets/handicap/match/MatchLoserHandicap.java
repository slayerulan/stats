package com.savik.football.bets.handicap.match;

import com.savik.football.bets.GeneralBet;
import com.savik.football.model.Match;
import com.savik.football.model.Period;
import com.savik.football.model.Who;

/**
 * @author Savushkin Yauheni
 * @since 17.05.2017
 */
public class MatchLoserHandicap extends GeneralBet {

    private int amount;

    public MatchLoserHandicap(int amount) {
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
        Who favorite = match.getBookieStats().getFavorite();
        Period period = match.getMatchInfo().getMatch();
        if (amount <= 0) {
            return period.getLoserScore(favorite) - period.getFavoriteScore(favorite) > Math.abs(amount);
        }
        return period.getFavoriteScore(favorite) - period.getLoserScore(favorite) < amount;
    }
}
