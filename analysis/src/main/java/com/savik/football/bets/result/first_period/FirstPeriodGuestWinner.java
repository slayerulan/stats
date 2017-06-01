package com.savik.football.bets.result.first_period;

import com.savik.football.bets.GeneralBet;
import com.savik.football.model.FootballMatch;
import lombok.*;

@Getter
public class FirstPeriodGuestWinner extends GeneralBet {

    public FirstPeriodGuestWinner() {
    }

    @Override
    public boolean canAnalyze(FootballMatch footballMatch) {
        return footballMatch.getMatchInfo().getFirstPeriod().getHomeScore() != null &&
               footballMatch.getMatchInfo().getFirstPeriod().getGuestScore() != null;
    }

    @Override
    public boolean check(FootballMatch footballMatch) {
        return footballMatch.getMatchInfo().getFirstPeriod().getGuestScore() >
               footballMatch.getMatchInfo().getFirstPeriod().getHomeScore();
    }
}
