package com.savik.football.bets.goals.first_period;

import com.savik.football.bets.GeneralBet;
import com.savik.football.bets.total.over.first_period.FirstPeriodGuestOver;
import com.savik.football.bets.total.over.first_period.FirstPeriodHomeOver;
import com.savik.football.model.Match;

public class FirstPeriodBothTeamsScored extends GeneralBet {

    private FirstPeriodHomeOver firstPeriodHomeOver;

    private FirstPeriodGuestOver firstPeriodGuestOver;

    public FirstPeriodBothTeamsScored() {
        firstPeriodHomeOver = new FirstPeriodHomeOver(0);
        firstPeriodGuestOver = new FirstPeriodGuestOver(0);
    }

    @Override
    public boolean canAnalyze(Match match) {
        return firstPeriodHomeOver.canAnalyze(match) && firstPeriodGuestOver.canAnalyze(match);
    }

    @Override
    public boolean check(Match match) {
        return firstPeriodHomeOver.check(match) && firstPeriodGuestOver.check(match);
    }
}
