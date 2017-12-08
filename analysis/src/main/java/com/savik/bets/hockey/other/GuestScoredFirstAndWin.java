package com.savik.bets.hockey.other;

import com.savik.*;
import com.savik.hockey.model.HockeyMatch;
import com.savik.hockey.model.HockeyMatchInfo;
import com.savik.hockey.model.HockeyPeriod;
import lombok.Getter;

import java.util.Optional;

@Getter
public class GuestScoredFirstAndWin extends GeneralBet<HockeyMatch> {

    public GuestScoredFirstAndWin() {
    }

    @Override
    public boolean canAnalyze(HockeyMatch hockeyMatch) {
        HockeyMatchInfo matchInfo = hockeyMatch.getMatchInfo();
        HockeyPeriod match = matchInfo.getMatch();
        Optional<Goal> goal = match.getGoal(Period.GoalOrder.FIRST);
        return goal.isPresent();
    }

    @Override
    public boolean check(HockeyMatch hockeyMatch) {
        HockeyMatchInfo matchInfo = hockeyMatch.getMatchInfo();
        HockeyPeriod match = matchInfo.getMatch();
        Goal goal = match.getGoal(Period.GoalOrder.FIRST).get();
        return goal.getWhoScored() == Who.GUEST && match.getWinner() == Winner.GUEST;
    }
}