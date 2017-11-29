package com.savik.bets.general.other;

import com.savik.Period;
import com.savik.PeriodFavoriteBet;
import com.savik.Who;
import com.savik.bets.general.total.under.PeriodUnder;
import lombok.Getter;

@Getter
public class PeriodFavoriteWinAndUnder extends PeriodFavoriteBet {

    private PeriodFavoriteBet whoWon;
    private PeriodUnder periodUnder;

    public PeriodFavoriteWinAndUnder(double amount, PeriodFavoriteBet whoWon) {
        this.whoWon = whoWon;
        this.periodUnder = new PeriodUnder(amount);
    }

    @Override
    public boolean canAnalyze(Who favorite, Period period) {
        return whoWon.canAnalyze(favorite, period) && periodUnder.canAnalyze(period);
    }

    @Override
    public boolean check(Who favorite, Period period) {
        return whoWon.check(favorite, period) && periodUnder.check(period);
    }
}
