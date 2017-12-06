package com.savik.bets.hockey.result;

import com.savik.GeneralBet;
import com.savik.PeriodBet;
import com.savik.bets.general.result.PeriodDraw;
import com.savik.hockey.model.HockeyMatch;
import com.savik.hockey.model.HockeyMatchInfo;

public class DrawAtLeastNPeriods extends GeneralBet<HockeyMatch> {

    private int n;
    private PeriodBet drawBet;

    public DrawAtLeastNPeriods(int n) {
        this.n = n;
        this.drawBet = new PeriodDraw();
    }

    @Override
    public boolean canAnalyze(HockeyMatch match) {
        HockeyMatchInfo matchInfo = match.getMatchInfo();
        return drawBet.canAnalyze(matchInfo.getFirstPeriod()) &&
                drawBet.canAnalyze(matchInfo.getSecondPeriod()) &&
                drawBet.canAnalyze(matchInfo.getThirdPeriod());
    }

    @Override
    public boolean check(HockeyMatch match) {
        HockeyMatchInfo matchInfo = match.getMatchInfo();
        boolean firstPeriodResult = drawBet.check(matchInfo.getFirstPeriod());
        boolean secondPeriodResult = drawBet.check(matchInfo.getSecondPeriod());
        boolean thirdPeriodResult = drawBet.check(matchInfo.getThirdPeriod());
        int amountOfWon = (firstPeriodResult ? 1 : 0) + (secondPeriodResult ? 1 : 0) + (thirdPeriodResult ? 1 : 0);
        return amountOfWon >= n;
    }
}
