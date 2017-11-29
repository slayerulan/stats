package com.savik.bets.general.goals;

import com.savik.Period;
import com.savik.PeriodBet;
import com.savik.bets.general.total.over.PeriodGuestOver;
import com.savik.bets.general.total.over.PeriodHomeOver;
import lombok.Getter;

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
