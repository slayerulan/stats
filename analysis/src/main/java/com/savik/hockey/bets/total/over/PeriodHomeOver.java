package com.savik.hockey.bets.total.over;

import com.savik.hockey.bets.PeriodBet;
import com.savik.hockey.model.HockeyPeriod;
import lombok.Getter;

@Getter
public class PeriodHomeOver extends PeriodBet {

    private double amount;

    public PeriodHomeOver(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean canAnalyze(HockeyPeriod period) {
        return period.getHomeScore() != null;
    }

    @Override
    public boolean check(HockeyPeriod period) {
        return period.getHomeScore() > amount;
    }
}
