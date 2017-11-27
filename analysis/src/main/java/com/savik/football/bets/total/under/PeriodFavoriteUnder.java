package com.savik.football.bets.total.under;

import com.savik.football.bets.PeriodFavoriteBet;
import com.savik.football.model.FootballPeriod;
import com.savik.Who;
import lombok.*;

@Getter
public class PeriodFavoriteUnder extends PeriodFavoriteBet {

    private double amount;

    public PeriodFavoriteUnder(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean canAnalyze(Who favorite, FootballPeriod period) {
        return favorite.isTeam() && period.getFavoriteScore(favorite) != null;
    }

    @Override
    public boolean check(Who favorite, FootballPeriod period) {
        return period.getFavoriteScore(favorite) < amount;
    }

}
