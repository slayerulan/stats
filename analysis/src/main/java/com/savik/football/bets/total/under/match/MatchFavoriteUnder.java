package com.savik.football.bets.total.under.match;

import com.savik.football.bets.GeneralBet;
import com.savik.football.model.FootballMatch;
import com.savik.football.model.Who;
import lombok.*;

@Getter
public class MatchFavoriteUnder extends GeneralBet {

    private double amount;

    public MatchFavoriteUnder(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean canAnalyze(FootballMatch footballMatch) {
        Who favorite = footballMatch.getBookieStats().getFavorite();
        if (favorite == Who.UNKNOWN) {
            return false;
        }
        if (favorite == Who.HOME) {
            return footballMatch.getMatchInfo().getMatch().getHomeScore() != null;
        }
        if (favorite == Who.GUEST) {
            return footballMatch.getMatchInfo().getMatch().getGuestScore() != null;
        }
        throw new IllegalArgumentException("Unknown favorite value = " + favorite);
    }

    @Override
    public boolean check(FootballMatch footballMatch) {
        Who favorite = footballMatch.getBookieStats().getFavorite();
        if (favorite == Who.HOME) {
            return footballMatch.getMatchInfo().getMatch().getHomeScore() < amount;
        }
        if (favorite == Who.GUEST) {
            return footballMatch.getMatchInfo().getMatch().getGuestScore() < amount;
        }
        throw new IllegalArgumentException("FootballMatch doesn't have favorite, check id = " + footballMatch.getId());
    }
}
