package com.savik.football.bets.handicap.second_period;

import com.savik.football.bets.GeneralBet;
import com.savik.football.model.FootballMatch;
import com.savik.football.model.Period;
import lombok.*;

/**
 * @author Savushkin Yauheni
 * @since 17.05.2017
 */
@Getter
public class SecondPeriodGuestHandicap extends GeneralBet {

    private double amount;

    public SecondPeriodGuestHandicap(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean canAnalyze(FootballMatch footballMatch) {
        return footballMatch.getMatchInfo().getSecondPeriod().getHomeScore() != null &&
               footballMatch.getMatchInfo().getSecondPeriod().getGuestScore() != null;
    }

    @Override
    public boolean check(FootballMatch footballMatch) {
        Period period = footballMatch.getMatchInfo().getSecondPeriod();
        if (amount <= 0) {
            return period.getGuestScore() - period.getHomeScore() > Math.abs(amount);
        }
        return period.getHomeScore() - period.getGuestScore() < amount;
    }
}
