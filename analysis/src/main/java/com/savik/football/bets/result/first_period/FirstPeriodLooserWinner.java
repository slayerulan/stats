package com.savik.football.bets.result.first_period;

import com.savik.football.bets.GeneralBet;
import com.savik.football.model.FootballMatch;
import lombok.*;

@Getter
public class FirstPeriodLooserWinner extends GeneralBet {

    public FirstPeriodLooserWinner() {
    }

    @Override
    public boolean canAnalyze(FootballMatch footballMatch) {
        return footballMatch.getBookieStats().hasFavorite() &&
               footballMatch
                       .getMatchInfo().getFirstPeriod().getFavoriteScore(footballMatch
                       .getBookieStats().getFavorite()) != null &&
               footballMatch
                       .getMatchInfo().getFirstPeriod().getLoserScore(footballMatch
                       .getBookieStats().getFavorite()) != null;
    }

    @Override
    public boolean check(FootballMatch footballMatch) {
        return footballMatch
                       .getMatchInfo().getFirstPeriod().getLoserScore(footballMatch
                        .getBookieStats().getFavorite()) >
               footballMatch.getMatchInfo().getFirstPeriod().getFavoriteScore(footballMatch.getBookieStats().getFavorite());
    }
}
