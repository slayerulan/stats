package com.savik.football.bets.goals.second_period;

import com.savik.football.bets.GeneralBet;
import com.savik.football.bets.total.over.second_period.SecondPeriodGuestOver;
import com.savik.football.bets.total.over.second_period.SecondPeriodHomeOver;
import com.savik.football.model.Match;
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
    public boolean canAnalyze(Match match) {
        return secondPeriodHomeOver.canAnalyze(match) && secondPeriodGuestOver.canAnalyze(match);
    }

    @Override
    public boolean check(Match match) {
        return secondPeriodHomeOver.check(match) && secondPeriodGuestOver.check(match);
    }
}
