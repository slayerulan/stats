package com.savik.football.bets.goals.first_period;

import com.savik.football.bets.GeneralBet;
import com.savik.football.bets.total.over.first_period.FirstPeriodGuestOver;
import com.savik.football.bets.total.over.first_period.FirstPeriodHomeOver;
import com.savik.football.model.FootballMatch;
import lombok.*;

@Getter
public class FirstPeriodBothTeamsScored extends GeneralBet {

    private FirstPeriodHomeOver firstPeriodHomeOver;

    private FirstPeriodGuestOver firstPeriodGuestOver;

    public FirstPeriodBothTeamsScored() {
        firstPeriodHomeOver = new FirstPeriodHomeOver(0);
        firstPeriodGuestOver = new FirstPeriodGuestOver(0);
    }

    @Override
    public boolean canAnalyze(FootballMatch footballMatch) {
        return firstPeriodHomeOver.canAnalyze(footballMatch) && firstPeriodGuestOver.canAnalyze(footballMatch);
    }

    @Override
    public boolean check(FootballMatch footballMatch) {
        return firstPeriodHomeOver.check(footballMatch) && firstPeriodGuestOver.check(footballMatch);
    }
}
