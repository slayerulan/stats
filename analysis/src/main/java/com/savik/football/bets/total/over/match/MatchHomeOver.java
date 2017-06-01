package com.savik.football.bets.total.over.match;

import com.savik.football.bets.GeneralBet;
import com.savik.football.model.FootballMatch;
import lombok.*;

@Getter
public class MatchHomeOver extends GeneralBet {
    private double amount;

    public MatchHomeOver(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean canAnalyze(FootballMatch footballMatch) {
        return footballMatch.getMatchInfo().getMatch().getHomeScore() != null;
    }

    @Override
    public boolean check(FootballMatch footballMatch) {
        return footballMatch.getMatchInfo().getMatch().getHomeScore() > amount;
    }
}
