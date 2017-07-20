package com.savik.football.bets.goals;

import com.savik.football.bets.PeriodBet;
import com.savik.football.bets.total.over.PeriodGuestOver;
import com.savik.football.bets.total.over.PeriodHomeOver;
import com.savik.football.model.Period;
import lombok.*;

@Getter
public class PeriodBothTeamsScored extends PeriodBet {

    private PeriodHomeOver periodHomeOver;

    private PeriodGuestOver periodGuestOver;

    public PeriodBothTeamsScored() {
        periodHomeOver = new PeriodHomeOver(0);
        periodGuestOver = new PeriodGuestOver(0);
    }

    @Override
    public boolean canAnalyze(Period period) {
        return periodHomeOver.canAnalyze(period) &&
               periodGuestOver.canAnalyze(period);
    }

    @Override
    public boolean check(Period period) {
        return periodHomeOver.check(period) &&
               periodGuestOver.check(period);
    }
}