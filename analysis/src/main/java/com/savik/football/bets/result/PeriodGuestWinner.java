package com.savik.football.bets.result;

import com.savik.football.bets.PeriodBet;
import com.savik.football.model.Period;
import lombok.*;

@Getter
public class PeriodGuestWinner extends PeriodBet {

    @Override
    public boolean canAnalyze(Period period) {
        return period.getGuestScore() != null && period.getHomeScore() != null;
    }

    @Override
    public boolean check(Period period) {
        return period.getGuestScore() > period.getHomeScore();
    }
}
