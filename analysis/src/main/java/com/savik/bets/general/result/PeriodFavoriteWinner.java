package com.savik.bets.general.result;

import com.savik.Period;
import com.savik.Who;
import com.savik.PeriodFavoriteBet;
import lombok.Getter;

@Getter
public class PeriodFavoriteWinner extends PeriodFavoriteBet {

    @Override
    public boolean canAnalyze(Who favorite, Period period) {
        return favorite.isTeam() && period.hasScores();
    }

    @Override
    public boolean check(Who favorite, Period period) {
        return period.getFavoriteScore(favorite) > period.getLoserScore(favorite);
    }
}
