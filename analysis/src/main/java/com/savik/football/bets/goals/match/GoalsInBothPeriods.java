package com.savik.football.bets.goals.match;

import com.savik.football.bets.GeneralBet;
import com.savik.football.bets.total.over.PeriodOver;
import com.savik.football.model.FootballMatch;
import com.savik.football.model.FootballMatchInfo;
import lombok.*;

@Getter
public class GoalsInBothPeriods extends GeneralBet<FootballMatch> {

    private PeriodOver periodOver;

    public GoalsInBothPeriods() {
        periodOver = new PeriodOver(0);
    }

    @Override
    public boolean canAnalyze(FootballMatch footballMatch) {
        FootballMatchInfo matchInfo = footballMatch.getMatchInfo();
        return periodOver.canAnalyze(matchInfo.getFirstPeriod()) &&
               periodOver.canAnalyze(matchInfo.getSecondPeriod());
    }

    @Override
    public boolean check(FootballMatch footballMatch) {
        FootballMatchInfo matchInfo = footballMatch.getMatchInfo();
        return periodOver.check(matchInfo.getFirstPeriod()) &&
               periodOver.check(matchInfo.getSecondPeriod());
    }
}
