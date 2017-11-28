package com.savik.football.bets.goals.match;

import com.savik.football.bets.GeneralBet;
import com.savik.football.bets.total.over.PeriodHomeOver;
import com.savik.football.model.FootballMatch;
import com.savik.football.model.FootballMatchInfo;
import lombok.*;

@Getter
public class HomeScoredBothPeriods extends GeneralBet<FootballMatch> {

    private PeriodHomeOver periodHomeOver;

    public HomeScoredBothPeriods() {
        periodHomeOver = new PeriodHomeOver(0);
    }

    @Override
    public boolean canAnalyze(FootballMatch footballMatch) {
        FootballMatchInfo matchInfo = footballMatch.getMatchInfo();
        return periodHomeOver.canAnalyze(matchInfo.getFirstPeriod()) &&
               periodHomeOver.canAnalyze(matchInfo.getSecondPeriod());
    }

    @Override
    public boolean check(FootballMatch footballMatch) {
        FootballMatchInfo matchInfo = footballMatch.getMatchInfo();
        return periodHomeOver.check(matchInfo.getFirstPeriod()) &&
               periodHomeOver.check(matchInfo.getSecondPeriod());
    }
}
