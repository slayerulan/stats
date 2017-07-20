package com.savik.football.bets.handicap;

import com.savik.football.bets.PeriodFavoriteBet;
import com.savik.football.model.Period;
import com.savik.football.model.Who;
import lombok.*;

/**
 * @author Savushkin Yauheni
 * @since 17.05.2017
 */
@Getter
public class PeriodLooserHandicap extends PeriodFavoriteBet {

    private double amount;

    public PeriodLooserHandicap(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean canAnalyze(Who favorite, Period period) {
        return favorite.isTeam() &&
               period.getHomeScore() != null &&
               period.getGuestScore() != null;
    }

    @Override
    public boolean check(Who favorite, Period period) {
        if (amount <= 0) {
            return period.getLoserScore(favorite) - period.getFavoriteScore(favorite) > Math.abs(amount);
        }
        return period.getFavoriteScore(favorite) - period.getLoserScore(favorite) < amount;
    }
}
