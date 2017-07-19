package com.savik.football.bets.result;

import com.savik.football.bets.PeriodFavoriteBet;
import com.savik.football.model.Period;
import com.savik.football.model.Who;
import lombok.*;

@Getter
public class PeriodFavoriteWinner extends PeriodFavoriteBet {

    @Override
    public boolean canAnalyze(Who favorite, Period period) {
        return favorite.isTeam() && period.getFavoriteScore(favorite) != null && period.getLoserScore(favorite) != null;
    }

    @Override
    public boolean check(Who favorite, Period period) {
        return period.getFavoriteScore(favorite) > period.getLoserScore(favorite);
    }
}
