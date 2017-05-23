package com.savik.football.bets.goals.match;

import com.savik.football.bets.GeneralBet;
import com.savik.football.bets.total.over.first_period.FirstPeriodHomeOver;
import com.savik.football.bets.total.over.second_period.SecondPeriodHomeOver;
import com.savik.football.model.Match;
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
    public boolean canAnalyze(Match match) {
        return firstPeriodHomeOver.canAnalyze(match) && secondPeriodHomeOver.canAnalyze(match);
    }

    @Override
    public boolean check(Match match) {
        return firstPeriodHomeOver.check(match) && secondPeriodHomeOver.check(match);
    }
}
