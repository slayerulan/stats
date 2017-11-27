package com.savik.football.bets.result;

import com.savik.football.bets.PeriodFavoriteBet;
import com.savik.football.model.FootballPeriod;
import com.savik.football.model.Who;
import lombok.*;

@Getter
public class PeriodFavoriteWinner extends PeriodFavoriteBet {

    @Override
    public boolean canAnalyze(Who favorite, FootballPeriod period) {
        return favorite.isTeam() && period.hasScores();
    }

    @Override
    public boolean check(Who favorite, FootballPeriod period) {
        return period.getFavoriteScore(favorite) > period.getLoserScore(favorite);
    }
}
