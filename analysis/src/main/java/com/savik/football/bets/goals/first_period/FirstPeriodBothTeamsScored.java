package com.savik.football.bets.goals.first_period;

import com.savik.football.bets.GeneralBet;
import com.savik.football.bets.total.over.PeriodGuestOver;
import com.savik.football.bets.total.over.PeriodHomeOver;
import com.savik.football.model.FootballMatch;
import lombok.*;

@Getter
public class FirstPeriodBothTeamsScored extends GeneralBet {

    private PeriodHomeOver firstPeriodHomeOver;

    private PeriodGuestOver firstPeriodGuestOver;

    public FirstPeriodBothTeamsScored() {
        firstPeriodHomeOver = new PeriodHomeOver(0);
        firstPeriodGuestOver = new PeriodGuestOver(0);
    }

    @Override
    public boolean canAnalyze(FootballMatch footballMatch) {
        return firstPeriodHomeOver.canAnalyze(footballMatch.getMatchInfo().getFirstPeriod()) &&
               firstPeriodGuestOver.canAnalyze(footballMatch.getMatchInfo().getFirstPeriod());
    }

    @Override
    public boolean check(FootballMatch footballMatch) {
        return firstPeriodHomeOver.check(footballMatch.getMatchInfo().getFirstPeriod()) &&
               firstPeriodGuestOver.check(footballMatch.getMatchInfo().getFirstPeriod());
    }
}
