package com.savik.football.bets.total.over.periods;

import com.savik.football.bets.GeneralBet;
import com.savik.football.bets.total.over.PeriodOver;
import com.savik.football.model.FootballMatch;
import lombok.*;

@Getter
public class EveryPeriodOver extends GeneralBet {

    private double amount;

    private PeriodOver firstPeriodOver;

    private PeriodOver secondPeriodOver;

    public EveryPeriodOver(double amount) {
        this.amount = amount;
        this.firstPeriodOver = new PeriodOver(amount);
        this.secondPeriodOver = new PeriodOver(amount);
    }

    @Override
    public boolean canAnalyze(FootballMatch footballMatch) {
        return this.firstPeriodOver.canAnalyze(footballMatch.getMatchInfo().getFirstPeriod())
               && this.secondPeriodOver.canAnalyze(footballMatch.getMatchInfo().getSecondPeriod());
    }

    @Override
    public boolean check(FootballMatch footballMatch) {
        return this.firstPeriodOver.check(footballMatch.getMatchInfo().getFirstPeriod())
               && this.secondPeriodOver.check(footballMatch.getMatchInfo().getSecondPeriod());
    }
}
