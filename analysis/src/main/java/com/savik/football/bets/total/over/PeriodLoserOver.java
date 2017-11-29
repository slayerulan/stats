package com.savik.football.bets.total.over;

import com.savik.Period;
import com.savik.Who;
import com.savik.PeriodFavoriteBet;
import lombok.Getter;

@Getter
public class PeriodLoserOver extends PeriodFavoriteBet {

    private double amount;

    public PeriodLoserOver(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean canAnalyze(Who favorite, Period period) {
        return favorite.isTeam() && period.getLoserScore(favorite) != null;
    }

    @Override
    public boolean check(Who favorite, Period period) {
        return period.getLoserScore(favorite) > amount;
    }
}
