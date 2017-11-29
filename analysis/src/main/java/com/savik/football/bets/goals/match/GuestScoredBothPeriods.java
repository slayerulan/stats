package com.savik.football.bets.goals.match;

import com.savik.GeneralBet;
import com.savik.general.bets.total.over.PeriodGuestOver;
import com.savik.football.model.FootballMatch;
import com.savik.football.model.FootballMatchInfo;
import lombok.*;

@Getter
public class GuestScoredBothPeriods extends GeneralBet<FootballMatch> {

    private PeriodGuestOver periodGuestOver;

    public GuestScoredBothPeriods() {
        periodGuestOver = new PeriodGuestOver(0);
    }

    @Override
    public boolean canAnalyze(FootballMatch footballMatch) {
        FootballMatchInfo matchInfo = footballMatch.getMatchInfo();
        return periodGuestOver.canAnalyze(matchInfo.getFirstPeriod()) &&
               periodGuestOver.canAnalyze(matchInfo.getSecondPeriod());
    }

    @Override
    public boolean check(FootballMatch footballMatch) {
        FootballMatchInfo matchInfo = footballMatch.getMatchInfo();
        return periodGuestOver.check(matchInfo.getFirstPeriod()) &&
               periodGuestOver.check(matchInfo.getSecondPeriod());
    }
}
