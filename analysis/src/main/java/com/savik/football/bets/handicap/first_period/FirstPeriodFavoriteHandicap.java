package com.savik.football.bets.handicap.first_period;

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
public class FirstPeriodFavoriteHandicap extends GeneralBet {

    private double amount;

    public FirstPeriodFavoriteHandicap(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean canAnalyze(FootballMatch footballMatch) {
        return footballMatch.getBookieStats().hasFavorite() &&
               footballMatch.getMatchInfo().getFirstPeriod().getHomeScore() != null &&
               footballMatch.getMatchInfo().getFirstPeriod().getGuestScore() != null;
    }

    @Override
    public boolean check(FootballMatch footballMatch) {
        Who favorite = footballMatch.getBookieStats().getFavorite();
        Period period = footballMatch.getMatchInfo().getFirstPeriod();
        if (amount <= 0) {
            return period.getFavoriteScore(favorite) - period.getLoserScore(favorite) > Math.abs(amount);
        }
        return period.getLoserScore(favorite) - period.getFavoriteScore(favorite) < amount;
    }
}
