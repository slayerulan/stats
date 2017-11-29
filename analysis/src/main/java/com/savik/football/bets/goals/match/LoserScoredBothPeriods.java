package com.savik.football.bets.goals.match;

import com.savik.GeneralBet;
import com.savik.bets.general.total.over.PeriodLoserOver;
import com.savik.football.model.FootballMatch;
import com.savik.football.model.FootballMatchInfo;
import com.savik.Who;
import lombok.*;

@Getter
public class LoserScoredBothPeriods extends GeneralBet<FootballMatch> {

    private PeriodLoserOver periodLoserOver;


    public LoserScoredBothPeriods() {
        periodLoserOver = new PeriodLoserOver(0);
    }

    @Override
    public boolean canAnalyze(FootballMatch footballMatch) {
        Who favorite = footballMatch.getBookieStats().getFavorite();
        FootballMatchInfo matchInfo = footballMatch.getMatchInfo();
        return periodLoserOver.canAnalyze(favorite, matchInfo.getFirstPeriod()) &&
               periodLoserOver.canAnalyze(favorite, matchInfo.getSecondPeriod());
    }

    @Override
    public boolean check(FootballMatch footballMatch) {
        Who favorite = footballMatch.getBookieStats().getFavorite();
        FootballMatchInfo matchInfo = footballMatch.getMatchInfo();
        return periodLoserOver.check(favorite, matchInfo.getFirstPeriod()) &&
               periodLoserOver.check(favorite, matchInfo.getSecondPeriod());
    }
}
