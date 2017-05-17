package com.savik.football.bets.total.under.periods;

import com.savik.football.bets.GeneralBet;
import com.savik.football.bets.total.under.first_period.FirstPeriodUnder;
import com.savik.football.bets.total.under.second_period.SecondPeriodUnder;
import com.savik.football.model.Match;

public class EveryPeriodUnder extends GeneralBet {

    private int amount;

    private FirstPeriodUnder firstPeriodUnder;
    private SecondPeriodUnder secondPeriodUnder;

    public EveryPeriodUnder(int amount) {
        this.amount = amount;
        this.firstPeriodUnder = new FirstPeriodUnder(amount);
        this.secondPeriodUnder = new SecondPeriodUnder(amount);
    }

    @Override
    public boolean canAnalyze(Match match) {
        return this.firstPeriodUnder.canAnalyze(match) && this.secondPeriodUnder.canAnalyze(match);
    }

    @Override
    public boolean check(Match match) {
        return this.firstPeriodUnder.check(match) && this.secondPeriodUnder.check(match);
    }
}
