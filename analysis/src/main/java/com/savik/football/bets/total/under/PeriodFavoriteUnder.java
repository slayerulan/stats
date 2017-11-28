package com.savik.football.bets.total.under;

import com.savik.Period;
import com.savik.Who;
import com.savik.football.bets.PeriodFavoriteBet;
import lombok.Getter;

@Getter
public class PeriodFavoriteUnder extends PeriodFavoriteBet {

    private double amount;

    public PeriodFavoriteUnder(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean canAnalyze(Who favorite, Period period) {
        return favorite.isTeam() && period.getFavoriteScore(favorite) != null;
    }

    @Override
    public boolean check(Who favorite, Period period) {
        return period.getFavoriteScore(favorite) < amount;
    }

}
