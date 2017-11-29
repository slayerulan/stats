package com.savik.bets.general.total.under;

import com.savik.Period;
import com.savik.PeriodBet;
import lombok.Getter;

@Getter
public class PeriodBothTeamsTotalUnder extends PeriodBet {

    private double amount;

    public PeriodBothTeamsTotalUnder(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean canAnalyze(Period period) {
        return period.hasScores();
    }

    @Override
    public boolean check(Period period) {
        return period.getGuestScore() < amount && period.getHomeScore() < amount;
    }
}
