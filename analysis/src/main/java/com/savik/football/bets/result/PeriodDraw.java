package com.savik.football.bets.result;

import com.savik.football.bets.PeriodBet;
import com.savik.football.model.Period;
import lombok.*;

@Getter
public class PeriodDraw extends PeriodBet {

    @Override
    public boolean canAnalyze(Period period) {
        return period.hasScores();
    }

    @Override
    public boolean check(Period period) {
        return period.getGuestScore().equals(period.getHomeScore());
    }
}
