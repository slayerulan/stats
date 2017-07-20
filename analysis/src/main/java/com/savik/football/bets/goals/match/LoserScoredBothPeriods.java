package com.savik.football.bets.goals.match;

import com.savik.football.bets.GeneralBet;
import com.savik.football.bets.total.over.PeriodLooserOver;
import com.savik.football.model.FootballMatch;
import com.savik.football.model.FootballMatchInfo;
import com.savik.football.model.Who;
import lombok.*;

@Getter
public class LoserScoredBothPeriods extends GeneralBet {

    private PeriodLooserOver periodLooserOver;


    public LoserScoredBothPeriods() {
        periodLooserOver = new PeriodLooserOver(0);
    }

    @Override
    public boolean canAnalyze(FootballMatch footballMatch) {
        Who favorite = footballMatch.getBookieStats().getFavorite();
        FootballMatchInfo matchInfo = footballMatch.getMatchInfo();
        return periodLooserOver.canAnalyze(favorite, matchInfo.getFirstPeriod()) &&
               periodLooserOver.canAnalyze(favorite, matchInfo.getSecondPeriod());
    }

    @Override
    public boolean check(FootballMatch footballMatch) {
        Who favorite = footballMatch.getBookieStats().getFavorite();
        FootballMatchInfo matchInfo = footballMatch.getMatchInfo();
        return periodLooserOver.check(favorite, matchInfo.getFirstPeriod()) &&
               periodLooserOver.check(favorite, matchInfo.getSecondPeriod());
    }
}
