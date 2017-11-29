package com.savik.bets.general.handicap;

import com.savik.Period;
import com.savik.Who;
import com.savik.PeriodFavoriteBet;
import lombok.Getter;

/**
 * @author Savushkin Yauheni
 * @since 17.05.2017
 */
@Getter
public class PeriodFavoriteHandicap extends PeriodFavoriteBet {

    private double amount;

    public PeriodFavoriteHandicap(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean canAnalyze(Who favorite, Period period) {
        return favorite.isTeam() && period.hasScores();
    }

    @Override
    public boolean check(Who favorite, Period period) {
        if (amount <= 0) {
            return period.getFavoriteScore(favorite) - period.getLoserScore(favorite) > Math.abs(amount);
        }
        return period.getLoserScore(favorite) - period.getFavoriteScore(favorite) < amount;
    }
}
