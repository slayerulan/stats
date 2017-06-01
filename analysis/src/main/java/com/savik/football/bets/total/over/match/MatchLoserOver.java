package com.savik.football.bets.total.over.match;

import com.savik.football.bets.GeneralBet;
import com.savik.football.model.FootballMatch;
import lombok.*;

@Getter
public class MatchLoserOver extends GeneralBet {

    private double amount;

    public MatchLoserOver(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean canAnalyze(FootballMatch footballMatch) {
        return footballMatch.getBookieStats().hasFavorite() &&
               footballMatch
                       .getMatchInfo().getMatch().getLoserScore(footballMatch.getBookieStats().getFavorite()) != null;
    }

    @Override
    public boolean check(FootballMatch footballMatch) {
        return footballMatch
                       .getMatchInfo().getMatch().getLoserScore(footballMatch.getBookieStats().getFavorite()) > amount;
    }
}
