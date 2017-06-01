package com.savik.football.bets.total.over.second_period;

import com.savik.football.bets.GeneralBet;
import com.savik.football.model.FootballMatch;
import lombok.*;

@Getter
public class SecondPeriodOver extends GeneralBet {
    private double amount;

    public SecondPeriodOver(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean canAnalyze(FootballMatch footballMatch) {
        return footballMatch.getMatchInfo().getSecondPeriod().getTotalScore() != null;
    }

    @Override
    public boolean check(FootballMatch footballMatch) {
        return footballMatch.getMatchInfo().getSecondPeriod().getTotalScore() > amount;
    }
}
