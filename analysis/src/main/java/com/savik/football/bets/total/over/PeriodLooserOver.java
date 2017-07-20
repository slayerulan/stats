package com.savik.football.bets.total.over;

import com.savik.football.bets.PeriodFavoriteBet;
import com.savik.football.model.Period;
import com.savik.football.model.Who;
import lombok.*;

@Getter
public class PeriodLooserOver extends PeriodFavoriteBet {

    private double amount;

    public PeriodLooserOver(double amount) {
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
