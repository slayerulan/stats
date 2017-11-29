package com.savik.football.bets.goals.match;

import com.savik.GeneralBet;
import com.savik.bets.general.total.over.PeriodFavoriteOver;
import com.savik.football.model.FootballMatch;
import com.savik.football.model.FootballMatchInfo;
import com.savik.Who;
import lombok.*;

@Getter
public class FavoriteScoredBothPeriods extends GeneralBet<FootballMatch> {

    private PeriodFavoriteOver periodFavoriteOver;

    public FavoriteScoredBothPeriods() {
        periodFavoriteOver = new PeriodFavoriteOver(0);
    }

    @Override
    public boolean canAnalyze(FootballMatch footballMatch) {
        Who favorite = footballMatch.getBookieStats().getFavorite();
        FootballMatchInfo matchInfo = footballMatch.getMatchInfo();
        return periodFavoriteOver.canAnalyze(favorite, matchInfo.getFirstPeriod()) &&
               periodFavoriteOver.canAnalyze(favorite, matchInfo.getSecondPeriod());
    }

    @Override
    public boolean check(FootballMatch footballMatch) {
        Who favorite = footballMatch.getBookieStats().getFavorite();
        FootballMatchInfo matchInfo = footballMatch.getMatchInfo();
        return periodFavoriteOver.check(favorite, matchInfo.getFirstPeriod()) &&
               periodFavoriteOver.check(favorite, matchInfo.getSecondPeriod());
    }
}
