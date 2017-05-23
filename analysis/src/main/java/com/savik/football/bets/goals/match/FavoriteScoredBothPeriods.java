package com.savik.football.bets.goals.match;

import com.savik.football.bets.GeneralBet;
import com.savik.football.bets.total.over.first_period.FirstPeriodFavoriteOver;
import com.savik.football.bets.total.over.second_period.SecondPeriodFavoriteOver;
import com.savik.football.model.Match;
import lombok.*;

@Getter
public class FavoriteScoredBothPeriods extends GeneralBet {

    private FirstPeriodFavoriteOver firstPeriodFavoriteOver;

    private SecondPeriodFavoriteOver secondPeriodFavoriteOver;

    public FavoriteScoredBothPeriods() {
        firstPeriodFavoriteOver = new FirstPeriodFavoriteOver(0);
        secondPeriodFavoriteOver = new SecondPeriodFavoriteOver(0);
    }

    @Override
    public boolean canAnalyze(Match match) {
        return firstPeriodFavoriteOver.canAnalyze(match) && secondPeriodFavoriteOver.canAnalyze(match);
    }

    @Override
    public boolean check(Match match) {
        return firstPeriodFavoriteOver.check(match) && secondPeriodFavoriteOver.check(match);
    }
}
