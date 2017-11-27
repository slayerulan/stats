package com.savik.football.bets.result;

import com.savik.football.bets.PeriodBet;
import com.savik.football.model.FootballPeriod;
import lombok.*;

@Getter
public class PeriodHomeWinner extends PeriodBet {

    @Override
    public boolean canAnalyze(FootballPeriod period) {
        return period.hasScores();
    }

    @Override
    public boolean check(FootballPeriod period) {
        return period.getHomeScore() > period.getGuestScore();
    }
}
