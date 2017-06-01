package com.savik.football.bets.goals.match;

import com.savik.football.bets.GeneralBet;
import com.savik.football.bets.total.over.first_period.FirstPeriodGuestOver;
import com.savik.football.bets.total.over.second_period.SecondPeriodGuestOver;
import com.savik.football.model.FootballMatch;
import lombok.*;

@Getter
public class GuestScoredBothPeriods extends GeneralBet {

    private FirstPeriodGuestOver firstPeriodGuestOver;

    private SecondPeriodGuestOver secondPeriodGuestOver;

    public GuestScoredBothPeriods() {
        firstPeriodGuestOver = new FirstPeriodGuestOver(0);
        secondPeriodGuestOver = new SecondPeriodGuestOver(0);
    }

    @Override
    public boolean canAnalyze(FootballMatch footballMatch) {
        return firstPeriodGuestOver.canAnalyze(footballMatch) && secondPeriodGuestOver.canAnalyze(footballMatch);
    }

    @Override
    public boolean check(FootballMatch footballMatch) {
        return firstPeriodGuestOver.check(footballMatch) && secondPeriodGuestOver.check(footballMatch);
    }
}
