package com.savik.football.bets.total.over.match;

import com.savik.football.bets.GeneralBet;
import com.savik.football.model.Match;
import com.savik.football.model.Who;
import lombok.*;

@Getter
public class MatchLoserOver extends GeneralBet {

    private double amount;

    public MatchLoserOver(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean canAnalyze(Match match) {
        return match.getBookieStats().hasFavorite() &&
               match.getMatchInfo().getMatch().getLoserScore(match.getBookieStats().getFavorite()) != null;
    }

    @Override
    public boolean check(Match match) {
        return match.getMatchInfo().getMatch().getLoserScore(match.getBookieStats().getFavorite()) > amount;
    }
}
