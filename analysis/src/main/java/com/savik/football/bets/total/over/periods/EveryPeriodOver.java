package com.savik.football.bets.total.over.periods;

import com.savik.GeneralBet;
import com.savik.football.bets.total.over.PeriodOver;
import com.savik.football.model.FootballMatch;
import lombok.*;

@Getter
public class EveryPeriodOver extends GeneralBet<FootballMatch> {

    private double amount;

    private PeriodOver periodOver;

    public EveryPeriodOver(double amount) {
        this.amount = amount;
        this.periodOver = new PeriodOver(amount);
    }

    @Override
    public boolean canAnalyze(FootballMatch footballMatch) {
        return periodOver.canAnalyze(footballMatch.getMatchInfo().getFirstPeriod())
               && periodOver.canAnalyze(footballMatch.getMatchInfo().getSecondPeriod());
    }

    @Override
    public boolean check(FootballMatch footballMatch) {
        return periodOver.check(footballMatch.getMatchInfo().getFirstPeriod())
               && periodOver.check(footballMatch.getMatchInfo().getSecondPeriod());
    }
}
