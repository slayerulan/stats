package com.savik.football.bets.handicap.second_period;

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
public class SecondPeriodLoserHandicap extends GeneralBet {

    private double amount;

    public SecondPeriodLoserHandicap(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean canAnalyze(FootballMatch footballMatch) {
        return footballMatch.getBookieStats().hasFavorite() &&
               footballMatch.getMatchInfo().getSecondPeriod().getHomeScore() != null &&
               footballMatch.getMatchInfo().getSecondPeriod().getGuestScore() != null;
    }

    @Override
    public boolean check(FootballMatch footballMatch) {
        Who favorite = footballMatch.getBookieStats().getFavorite();
        Period period = footballMatch.getMatchInfo().getSecondPeriod();
        if (amount <= 0) {
            return period.getLoserScore(favorite) - period.getFavoriteScore(favorite) > Math.abs(amount);
        }
        return period.getFavoriteScore(favorite) - period.getLoserScore(favorite) < amount;
    }
}
