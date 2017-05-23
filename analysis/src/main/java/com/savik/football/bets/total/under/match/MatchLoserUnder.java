package com.savik.football.bets.total.under.match;

import com.savik.football.bets.GeneralBet;
import com.savik.football.model.Match;
import com.savik.football.model.Who;
import lombok.*;

@Getter
public class MatchLoserUnder extends GeneralBet {

    private double amount;

    public MatchLoserUnder(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean canAnalyze(Match match) {
        Who favorite = match.getBookieStats().getFavorite();
        if (favorite == Who.UNKNOWN) {
            return false;
        }
        if (favorite == Who.HOME) {
            return match.getMatchInfo().getMatch().getGuestScore() != null;
        }
        if (favorite == Who.GUEST) {
            return match.getMatchInfo().getMatch().getHomeScore() != null;
        }
        throw new IllegalArgumentException("Unknown favorite value = " + favorite);
    }

    @Override
    public boolean check(Match match) {
        Who favorite = match.getBookieStats().getFavorite();
        if (favorite == Who.HOME) {
            return match.getMatchInfo().getMatch().getGuestScore() < amount;
        }
        if (favorite == Who.GUEST) {
            return match.getMatchInfo().getMatch().getHomeScore() < amount;
        }
        throw new IllegalArgumentException("Match doesn't have favorite, check id = " + match.getId());
    }
}
