package com.savik.football.bets.total.over.periods;

import com.savik.football.bets.GeneralBet;
import com.savik.football.bets.total.over.first_period.FirstPeriodOver;
import com.savik.football.bets.total.over.second_period.SecondPeriodOver;
import com.savik.football.model.FootballMatch;
import lombok.*;

@Getter
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
    public boolean canAnalyze(FootballMatch footballMatch) {
        return this.firstPeriodOver.canAnalyze(footballMatch) && this.secondPeriodOver.canAnalyze(footballMatch);
    }

    @Override
    public boolean check(FootballMatch footballMatch) {
        return this.firstPeriodOver.check(footballMatch) && this.secondPeriodOver.check(footballMatch);
    }
}
