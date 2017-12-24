package com.savik.bets.hockey.other;

import com.savik.GeneralBet;
import com.savik.Period;
import com.savik.hockey.model.HockeyMatch;
import com.savik.hockey.model.HockeyMatchInfo;
import com.savik.hockey.model.HockeyPeriod;
import lombok.Getter;

@Getter
public class PeriodXMoreEffectiveThanY extends GeneralBet<HockeyMatch> {

    private Period.PeriodStatus x;
    private Period.PeriodStatus y;

    public PeriodXMoreEffectiveThanY(Period.PeriodStatus x,Period.PeriodStatus y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean canAnalyze(HockeyMatch hockeyMatch) {
        HockeyMatchInfo matchInfo = hockeyMatch.getMatchInfo();
        HockeyPeriod xPeriod = matchInfo.getByStatus(x);
        HockeyPeriod yPeriod = matchInfo.getByStatus(y);
        return xPeriod != null && yPeriod != null && xPeriod.getTotalScore() != null && yPeriod.getTotalScore() != null;
    }

    @Override
    public boolean check(HockeyMatch hockeyMatch) {
        HockeyMatchInfo matchInfo = hockeyMatch.getMatchInfo();
        HockeyPeriod xPeriod = matchInfo.getByStatus(x);
        HockeyPeriod yPeriod = matchInfo.getByStatus(y);
        return xPeriod.getTotalScore() > yPeriod.getTotalScore();
    }

}
