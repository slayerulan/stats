package com.savik.football.bets.handicap.second_period;

import com.savik.football.bets.GeneralBet;
import com.savik.football.model.Match;
import com.savik.football.model.Period;

/**
 * @author Savushkin Yauheni
 * @since 17.05.2017
 */
public class SecondPeriodHomeHandicap extends GeneralBet {

    private double amount;

    public SecondPeriodHomeHandicap(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean canAnalyze(Match match) {
        return match.getMatchInfo().getSecondPeriod().getHomeScore() != null &&
               match.getMatchInfo().getSecondPeriod().getGuestScore() != null;
    }

    @Override
    public boolean check(Match match) {
        Period period = match.getMatchInfo().getSecondPeriod();
        if (amount <= 0) {
            return period.getHomeScore() - period.getGuestScore() > Math.abs(amount);
        }
        return period.getGuestScore() - period.getHomeScore() < amount;
    }
}
