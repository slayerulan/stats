package com.savik.bets.hockey.result;

import com.savik.GeneralBet;
import com.savik.PeriodBet;
import com.savik.hockey.model.HockeyMatch;
import com.savik.hockey.model.HockeyMatchInfo;

public class WinAtLeastNPeriods extends GeneralBet<HockeyMatch> {

    private int n;
    private PeriodBet whoWon;

    public WinAtLeastNPeriods(int n, PeriodBet whoWon) {
        this.n = n;
        this.whoWon = whoWon;
    }

    @Override
    public boolean canAnalyze(HockeyMatch match) {
        HockeyMatchInfo matchInfo = match.getMatchInfo();
        return whoWon.canAnalyze(matchInfo.getFirstPeriod()) &&
                whoWon.canAnalyze(matchInfo.getSecondPeriod()) &&
                whoWon.canAnalyze(matchInfo.getThirdPeriod());
    }

    @Override
    public boolean check(HockeyMatch match) {
        HockeyMatchInfo matchInfo = match.getMatchInfo();
        boolean firstPeriodResult = whoWon.check(matchInfo.getFirstPeriod());
        boolean secondPeriodResult = whoWon.check(matchInfo.getSecondPeriod());
        boolean thirdPeriodResult = whoWon.check(matchInfo.getThirdPeriod());
        int amountOfWon = (firstPeriodResult ? 1 : 0) + (secondPeriodResult ? 1 : 0) + (thirdPeriodResult ? 1 : 0);
        return amountOfWon >= n;
    }
}
