package com.savik.bets.hockey.goals.match;

import com.savik.GeneralBet;
import com.savik.bets.general.total.over.PeriodGuestOver;
import com.savik.hockey.model.HockeyMatch;
import com.savik.hockey.model.HockeyMatchInfo;
import lombok.Getter;

@Getter
public class GuestTotalOverInAllPeriods extends GeneralBet<HockeyMatch> {

    private PeriodGuestOver periodOver;

    public GuestTotalOverInAllPeriods(double amount) {
        periodOver = new PeriodGuestOver(amount);
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
