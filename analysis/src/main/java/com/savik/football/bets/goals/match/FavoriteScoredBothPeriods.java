package com.savik.football.bets.goals.match;

import com.savik.football.bets.GeneralBet;
import com.savik.football.bets.total.over.first_period.FirstPeriodFavoriteOver;
import com.savik.football.bets.total.over.second_period.SecondPeriodFavoriteOver;
import com.savik.football.model.FootballMatch;
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
    public boolean canAnalyze(FootballMatch footballMatch) {
        return firstPeriodFavoriteOver.canAnalyze(footballMatch) && secondPeriodFavoriteOver.canAnalyze(footballMatch);
    }

    @Override
    public boolean check(FootballMatch footballMatch) {
        return firstPeriodFavoriteOver.check(footballMatch) && secondPeriodFavoriteOver.check(footballMatch);
    }
}
