package com.savik.football.bets.total.under.first_period;

import com.savik.football.bets.GeneralBet;
import com.savik.football.model.Match;
import com.savik.football.model.Who;

public class FirstPeriodFavoriteUnder extends GeneralBet {

    private int amount;

    public FirstPeriodFavoriteUnder(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean canAnalyze(Match match) {
        Who favorite = match.getBookieStats().getFavorite();
        if (favorite == Who.UNKNOWN) {
            return false;
        }
        if (favorite == Who.HOME) {
            return match.getMatchInfo().getFirstPeriod().getHomeScore() != null;
        }
        if (favorite == Who.GUEST) {
            return match.getMatchInfo().getFirstPeriod().getGuestScore() != null;
        }
        throw new IllegalArgumentException("Unknown favorite value = " + favorite);
    }

    @Override
    public boolean check(Match match) {
        Who favorite = match.getBookieStats().getFavorite();
        if (favorite == Who.HOME) {
            return match.getMatchInfo().getFirstPeriod().getHomeScore() < amount;
        }
        if (favorite == Who.GUEST) {
            return match.getMatchInfo().getFirstPeriod().getGuestScore() < amount;
        }
        throw new IllegalArgumentException("Match doesn't have favorite, check id = " + match.getId());
    }
}
