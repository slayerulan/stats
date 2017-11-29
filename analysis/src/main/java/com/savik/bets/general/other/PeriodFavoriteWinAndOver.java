package com.savik.bets.general.other;

import com.savik.Period;
import com.savik.PeriodFavoriteBet;
import com.savik.Who;
import com.savik.bets.general.total.over.PeriodOver;
import lombok.Getter;

@Getter
public class PeriodFavoriteWinAndOver extends PeriodFavoriteBet {

    private PeriodFavoriteBet whoWon;
    private PeriodOver periodOver;

    public PeriodFavoriteWinAndOver(double amount, PeriodFavoriteBet whoWon) {
        this.whoWon = whoWon;
        this.periodOver = new PeriodOver(amount);
    }

    @Override
    public boolean canAnalyze(Who favorite, Period period) {
        return whoWon.canAnalyze(favorite, period) && periodOver.canAnalyze(period);
    }

    @Override
    public boolean check(Who favorite, Period period) {
        return whoWon.check(favorite, period) && periodOver.check(period);
    }
}
