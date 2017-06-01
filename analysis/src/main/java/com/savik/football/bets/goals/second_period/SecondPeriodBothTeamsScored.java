package com.savik.football.bets.goals.second_period;

import com.savik.football.bets.GeneralBet;
import com.savik.football.bets.total.over.second_period.SecondPeriodGuestOver;
import com.savik.football.bets.total.over.second_period.SecondPeriodHomeOver;
import com.savik.football.model.FootballMatch;
import lombok.*;

@Getter
public class SecondPeriodBothTeamsScored extends GeneralBet {

    private SecondPeriodHomeOver secondPeriodHomeOver;

    private SecondPeriodGuestOver secondPeriodGuestOver;

    public SecondPeriodBothTeamsScored() {
        secondPeriodHomeOver = new SecondPeriodHomeOver(0);
        secondPeriodGuestOver = new SecondPeriodGuestOver(0);
    }

    @Override
    public boolean canAnalyze(FootballMatch footballMatch) {
        return secondPeriodHomeOver.canAnalyze(footballMatch) && secondPeriodGuestOver.canAnalyze(footballMatch);
    }

    @Override
    public boolean check(FootballMatch footballMatch) {
        return secondPeriodHomeOver.check(footballMatch) && secondPeriodGuestOver.check(footballMatch);
    }
}
