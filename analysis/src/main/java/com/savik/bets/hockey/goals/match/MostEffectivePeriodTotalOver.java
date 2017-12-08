package com.savik.bets.hockey.goals.match;

import com.savik.GeneralBet;
import com.savik.bets.general.total.over.PeriodOver;
import com.savik.hockey.model.HockeyMatch;
import com.savik.hockey.model.HockeyMatchInfo;
import lombok.Getter;

@Getter
public class MostEffectivePeriodTotalOver extends GeneralBet<HockeyMatch> {

    private PeriodOver periodOver;

    public MostEffectivePeriodTotalOver(double amount) {
        periodOver = new PeriodOver(amount);
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
        return periodOver.check(matchInfo.getFirstPeriod()) ||
                periodOver.check(matchInfo.getSecondPeriod()) ||
                periodOver.check(matchInfo.getThirdPeriod());
    }
}
