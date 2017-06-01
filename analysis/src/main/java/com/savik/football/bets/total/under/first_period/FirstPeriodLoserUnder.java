package com.savik.football.bets.total.under.first_period;

import com.savik.football.bets.GeneralBet;
import com.savik.football.model.FootballMatch;
import com.savik.football.model.Who;
import lombok.*;

@Getter
public class FirstPeriodLoserUnder extends GeneralBet {

    private double amount;

    public FirstPeriodLoserUnder(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean canAnalyze(FootballMatch footballMatch) {
        Who favorite = footballMatch.getBookieStats().getFavorite();
        if (favorite == Who.UNKNOWN) {
            return false;
        }
        if (favorite == Who.HOME) {
            return footballMatch.getMatchInfo().getFirstPeriod().getGuestScore() != null;
        }
        if (favorite == Who.GUEST) {
            return footballMatch.getMatchInfo().getFirstPeriod().getHomeScore() != null;
        }
        throw new IllegalArgumentException("Unknown favorite value = " + favorite);
    }

    @Override
    public boolean check(FootballMatch footballMatch) {
        Who favorite = footballMatch.getBookieStats().getFavorite();
        if (favorite == Who.HOME) {
            return footballMatch.getMatchInfo().getFirstPeriod().getGuestScore() < amount;
        }
        if (favorite == Who.GUEST) {
            return footballMatch.getMatchInfo().getFirstPeriod().getHomeScore() < amount;
        }
        throw new IllegalArgumentException("FootballMatch doesn't have favorite, check id = " + footballMatch.getId());
    }
}
