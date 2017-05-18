package com.savik.football.bets.result.first_period;

import com.savik.football.bets.GeneralBet;
import com.savik.football.model.Match;

public class FirstPeriodHomeWinner extends GeneralBet {

    public FirstPeriodHomeWinner() {
    }

    @Override
    public boolean canAnalyze(Match match) {
        return match.getMatchInfo().getFirstPeriod().getHomeScore() != null &&
               match.getMatchInfo().getFirstPeriod().getGuestScore() != null;
    }

    @Override
    public boolean check(Match match) {
        return match.getMatchInfo().getFirstPeriod().getHomeScore() >
               match.getMatchInfo().getFirstPeriod().getGuestScore();
    }
}
