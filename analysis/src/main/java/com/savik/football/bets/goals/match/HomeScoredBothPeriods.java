package com.savik.football.bets.goals.match;

import com.savik.football.bets.GeneralBet;
import com.savik.football.bets.total.over.first_period.FirstPeriodHomeOver;
import com.savik.football.bets.total.over.second_period.SecondPeriodHomeOver;
import com.savik.football.model.FootballMatch;
import lombok.*;

@Getter
public class HomeScoredBothPeriods extends GeneralBet {

    private FirstPeriodHomeOver firstPeriodHomeOver;

    private SecondPeriodHomeOver secondPeriodHomeOver;

    public HomeScoredBothPeriods() {
        firstPeriodHomeOver = new FirstPeriodHomeOver(0);
        secondPeriodHomeOver = new SecondPeriodHomeOver(0);
    }

    @Override
    public boolean canAnalyze(FootballMatch footballMatch) {
        return firstPeriodHomeOver.canAnalyze(footballMatch) && secondPeriodHomeOver.canAnalyze(footballMatch);
    }

    @Override
    public boolean check(FootballMatch footballMatch) {
        return firstPeriodHomeOver.check(footballMatch) && secondPeriodHomeOver.check(footballMatch);
    }
}
