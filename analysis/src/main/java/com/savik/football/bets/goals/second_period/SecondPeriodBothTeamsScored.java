package com.savik.football.bets.goals.second_period;

import com.savik.football.bets.GeneralBet;
import com.savik.football.bets.total.over.PeriodGuestOver;
import com.savik.football.bets.total.over.PeriodHomeOver;
import com.savik.football.model.FootballMatch;
import lombok.*;

@Getter
public class SecondPeriodBothTeamsScored extends GeneralBet {

    private PeriodHomeOver secondPeriodHomeOver;

    private PeriodGuestOver secondPeriodGuestOver;

    public SecondPeriodBothTeamsScored() {
        secondPeriodHomeOver = new PeriodHomeOver(0);
        secondPeriodGuestOver = new PeriodGuestOver(0);
    }

    @Override
    public boolean canAnalyze(FootballMatch footballMatch) {
        return secondPeriodHomeOver.canAnalyze(footballMatch.getMatchInfo().getSecondPeriod()) &&
               secondPeriodGuestOver.canAnalyze(footballMatch.getMatchInfo().getSecondPeriod());
    }

    @Override
    public boolean check(FootballMatch footballMatch) {
        return secondPeriodHomeOver.check(footballMatch.getMatchInfo().getSecondPeriod()) &&
               secondPeriodGuestOver.check(footballMatch.getMatchInfo().getSecondPeriod());
    }
}
