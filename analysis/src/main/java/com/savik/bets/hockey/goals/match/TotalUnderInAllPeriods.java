package com.savik.bets.hockey.goals.match;

import com.savik.GeneralBet;
import com.savik.bets.general.total.over.PeriodOver;
import com.savik.bets.general.total.under.PeriodUnder;
import com.savik.hockey.model.HockeyMatch;
import com.savik.hockey.model.HockeyMatchInfo;
import lombok.Getter;

@Getter
public class TotalUnderInAllPeriods extends GeneralBet<HockeyMatch> {

    private PeriodUnder periodUnder;

    public TotalUnderInAllPeriods(double amount) {
        periodUnder = new PeriodUnder(amount);
    }

    @Override
    public boolean canAnalyze(HockeyMatch hockeyMatch) {
        HockeyMatchInfo matchInfo = hockeyMatch.getMatchInfo();
        return periodUnder.canAnalyze(matchInfo.getFirstPeriod()) &&
                periodUnder.canAnalyze(matchInfo.getSecondPeriod()) &&
                periodUnder.canAnalyze(matchInfo.getThirdPeriod());
    }

    @Override
    public boolean check(HockeyMatch hockeyMatch) {
        HockeyMatchInfo matchInfo = hockeyMatch.getMatchInfo();
        return periodUnder.check(matchInfo.getFirstPeriod()) &&
                periodUnder.check(matchInfo.getSecondPeriod()) &&
                periodUnder.check(matchInfo.getThirdPeriod());
    }
}
