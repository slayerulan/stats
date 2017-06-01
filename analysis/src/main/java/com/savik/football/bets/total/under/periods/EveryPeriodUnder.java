package com.savik.football.bets.total.under.periods;

import com.savik.football.bets.GeneralBet;
import com.savik.football.bets.total.under.first_period.FirstPeriodUnder;
import com.savik.football.bets.total.under.second_period.SecondPeriodUnder;
import com.savik.football.model.FootballMatch;
import lombok.*;

@Getter
public class EveryPeriodUnder extends GeneralBet {

    private double amount;

    private FirstPeriodUnder firstPeriodUnder;
    private SecondPeriodUnder secondPeriodUnder;

    public EveryPeriodUnder(double amount) {
        this.amount = amount;
        this.firstPeriodUnder = new FirstPeriodUnder(amount);
        this.secondPeriodUnder = new SecondPeriodUnder(amount);
    }

    @Override
    public boolean canAnalyze(FootballMatch footballMatch) {
        return this.firstPeriodUnder.canAnalyze(footballMatch) && this.secondPeriodUnder.canAnalyze(footballMatch);
    }

    @Override
    public boolean check(FootballMatch footballMatch) {
        return this.firstPeriodUnder.check(footballMatch) && this.secondPeriodUnder.check(footballMatch);
    }
}
