package com.savik.football.bets.total.over.periods;

import com.savik.football.bets.GeneralBet;
import com.savik.football.bets.total.over.first_period.FirstPeriodOver;
import com.savik.football.bets.total.over.second_period.SecondPeriodOver;
import com.savik.football.model.Match;

public class EveryPeriodOver extends GeneralBet {

    private double amount;

    private FirstPeriodOver firstPeriodOver;
    private SecondPeriodOver secondPeriodOver;

    public EveryPeriodOver(double amount) {
        this.amount = amount;
        this.firstPeriodOver = new FirstPeriodOver(amount);
        this.secondPeriodOver = new SecondPeriodOver(amount);
    }

    @Override
    public boolean canAnalyze(Match match) {
        return this.firstPeriodOver.canAnalyze(match) && this.secondPeriodOver.canAnalyze(match);
    }

    @Override
    public boolean check(Match match) {
        return this.firstPeriodOver.check(match) && this.secondPeriodOver.check(match);
    }
}
