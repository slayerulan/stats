package com.savik.football.bets.handicap.first_period;

import com.savik.football.bets.GeneralBet;
import com.savik.football.model.Match;
import com.savik.football.model.Period;
import lombok.*;

/**
 * @author Savushkin Yauheni
 * @since 17.05.2017
 */
@Getter
public class FirstPeriodGuestHandicap extends GeneralBet {

    private double amount;

    public FirstPeriodGuestHandicap(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean canAnalyze(Match match) {
        return match.getMatchInfo().getFirstPeriod().getHomeScore() != null &&
               match.getMatchInfo().getFirstPeriod().getGuestScore() != null;
    }

    @Override
    public boolean check(Match match) {
        Period period = match.getMatchInfo().getFirstPeriod();
        if (amount <= 0) {
            return period.getGuestScore() - period.getHomeScore() > Math.abs(amount);
        }
        return period.getHomeScore() - period.getGuestScore() < amount;
    }
}
