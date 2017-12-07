package com.savik.bets.hockey.goals.match;

import com.savik.GeneralBet;
import com.savik.bets.general.total.over.PeriodHomeOver;
import com.savik.hockey.model.HockeyMatch;
import com.savik.hockey.model.HockeyMatchInfo;
import lombok.Getter;

@Getter
public class HomeTotalOverInAllPeriods extends GeneralBet<HockeyMatch> {

    private PeriodHomeOver periodOver;

    public HomeTotalOverInAllPeriods(double amount) {
        periodOver = new PeriodHomeOver(amount);
    }

    @Override
    public boolean canAnalyze(HockeyMatch hockeyMatch) {
        HockeyMatchInfo matchInfo = hockeyMatch.getMatchInfo();
        return periodOver.canAnalyze(matchInfo.getFirstPeriod()) &&
                periodOver.canAnalyze(matchInfo.getSecondPeriod()) &&
                periodOver.canAnalyze(matchInfo.getThirdPeriod());
    }

    @Override
    public boolean check(HockeyMatch hockeyMatch) {
        HockeyMatchInfo matchInfo = hockeyMatch.getMatchInfo();
        return periodOver.check(matchInfo.getFirstPeriod()) &&
                periodOver.check(matchInfo.getSecondPeriod()) &&
                periodOver.check(matchInfo.getThirdPeriod());
    }
}
