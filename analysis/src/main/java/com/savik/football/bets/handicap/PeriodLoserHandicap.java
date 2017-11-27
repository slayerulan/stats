package com.savik.football.bets.handicap;

import com.savik.football.bets.PeriodFavoriteBet;
import com.savik.football.model.FootballPeriod;
import com.savik.Who;
import lombok.*;

/**
 * @author Savushkin Yauheni
 * @since 17.05.2017
 */
@Getter
public class PeriodLoserHandicap extends PeriodFavoriteBet {

    private double amount;

    public PeriodLoserHandicap(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean canAnalyze(Who favorite, FootballPeriod period) {
        return favorite.isTeam() && period.hasScores();
    }

    @Override
    public boolean check(Who favorite, FootballPeriod period) {
        if (amount <= 0) {
            return period.getLoserScore(favorite) - period.getFavoriteScore(favorite) > Math.abs(amount);
        }
        return period.getFavoriteScore(favorite) - period.getLoserScore(favorite) < amount;
    }
}
