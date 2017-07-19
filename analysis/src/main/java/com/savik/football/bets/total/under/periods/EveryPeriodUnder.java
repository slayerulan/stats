package com.savik.football.bets.total.under.periods;

import com.savik.football.bets.GeneralBet;
import com.savik.football.bets.total.under.PeriodUnder;
import com.savik.football.model.FootballMatch;
import lombok.*;

@Getter
public class EveryPeriodUnder extends GeneralBet {

    private double amount;

    private PeriodUnder periodUnder;

    public EveryPeriodUnder(double amount) {
        this.amount = amount;
        this.periodUnder = new PeriodUnder(amount);
    }

    @Override
    public boolean canAnalyze(FootballMatch footballMatch) {
        return periodUnder.canAnalyze(footballMatch.getMatchInfo().getFirstPeriod())
               && periodUnder.canAnalyze(footballMatch.getMatchInfo().getSecondPeriod());
    }

    @Override
    public boolean check(FootballMatch footballMatch) {
        return periodUnder.check(footballMatch.getMatchInfo().getFirstPeriod()) &&
               periodUnder.check(footballMatch.getMatchInfo().getSecondPeriod());
    }
}
