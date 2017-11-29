package com.savik.bets.general.total.over;

import com.savik.Period;
import com.savik.PeriodBet;
import lombok.Getter;

@Getter
public class PeriodBothTeamsTotalOver extends PeriodBet {

    private double amount;

    public PeriodBothTeamsTotalOver(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean canAnalyze(Period period) {
        return period.hasScores();
    }

    @Override
    public boolean check(Period period) {
        return period.getGuestScore() > amount && period.getHomeScore() > amount;
    }
}
