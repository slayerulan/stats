package com.savik.football.bets.total.under.second_period;

import com.savik.football.bets.GeneralBet;
import com.savik.football.model.Match;
import com.savik.football.model.Who;

public class SecondPeriodFavoriteUnder extends GeneralBet {

    private int amount;

    public SecondPeriodFavoriteUnder(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean canAnalyze(Match match) {
        Who favorite = match.getBookieStats().getFavorite();
        if (favorite == Who.UNKNOWN) {
            return false;
        }
        if (favorite == Who.HOME) {
            return match.getMatchInfo().getSecondPeriod().getHomeScore() != null;
        }
        if (favorite == Who.GUEST) {
            return match.getMatchInfo().getSecondPeriod().getGuestScore() != null;
        }
        throw new IllegalArgumentException("Unknown favorite value = " + favorite);
    }

    @Override
    public boolean check(Match match) {
        Who favorite = match.getBookieStats().getFavorite();
        if (favorite == Who.HOME) {
            return match.getMatchInfo().getSecondPeriod().getHomeScore() < amount;
        }
        if (favorite == Who.GUEST) {
            return match.getMatchInfo().getSecondPeriod().getGuestScore() < amount;
        }
        throw new IllegalArgumentException("Match doesn't have favorite, check id = " + match.getId());
    }
}
