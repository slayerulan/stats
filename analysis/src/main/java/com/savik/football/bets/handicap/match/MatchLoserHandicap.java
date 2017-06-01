package com.savik.football.bets.handicap.match;

import com.savik.football.bets.GeneralBet;
import com.savik.football.model.FootballMatch;
import com.savik.football.model.Period;
import com.savik.football.model.Who;
import lombok.*;

/**
 * @author Savushkin Yauheni
 * @since 17.05.2017
 */
@Getter
public class MatchLoserHandicap extends GeneralBet {

    private double amount;

    public MatchLoserHandicap(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean canAnalyze(FootballMatch footballMatch) {
        return footballMatch.getBookieStats().hasFavorite() &&
               footballMatch.getMatchInfo().getMatch().getHomeScore() != null &&
               footballMatch.getMatchInfo().getMatch().getGuestScore() != null;
    }

    @Override
    public boolean check(FootballMatch footballMatch) {
        Who favorite = footballMatch.getBookieStats().getFavorite();
        Period period = footballMatch.getMatchInfo().getMatch();
        if (amount <= 0) {
            return period.getLoserScore(favorite) - period.getFavoriteScore(favorite) > Math.abs(amount);
        }
        return period.getFavoriteScore(favorite) - period.getLoserScore(favorite) < amount;
    }
}
