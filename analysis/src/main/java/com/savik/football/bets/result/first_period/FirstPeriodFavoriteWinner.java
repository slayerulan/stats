package com.savik.football.bets.result.first_period;

import com.savik.football.bets.GeneralBet;
import com.savik.football.model.Match;

public class FirstPeriodFavoriteWinner extends GeneralBet {

    public FirstPeriodFavoriteWinner() {
    }

    @Override
    public boolean canAnalyze(Match match) {
        return match.getBookieStats().hasFavorite() &&
               match.getMatchInfo().getFirstPeriod().getFavoriteScore(match.getBookieStats().getFavorite()) != null &&
               match.getMatchInfo().getFirstPeriod().getLoserScore(match.getBookieStats().getFavorite()) != null;
    }

    @Override
    public boolean check(Match match) {
        return match.getMatchInfo().getFirstPeriod().getFavoriteScore(match.getBookieStats().getFavorite()) >
               match.getMatchInfo().getFirstPeriod().getLoserScore(match.getBookieStats().getFavorite());
    }
}
