package com.savik.bets.hockey.other;

import com.savik.GeneralBet;
import com.savik.Who;
import com.savik.hockey.model.HockeyGoal;
import com.savik.hockey.model.HockeyMatch;
import com.savik.hockey.model.HockeyMatchInfo;
import com.savik.hockey.model.HockeyPeriod;
import lombok.Getter;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
public class HomeScoredNInRow extends GeneralBet<HockeyMatch> {

    private int n;

    public HomeScoredNInRow(int n) {
        this.n = n;
    }

    @Override
    public boolean canAnalyze(HockeyMatch hockeyMatch) {
        HockeyMatchInfo matchInfo = hockeyMatch.getMatchInfo();
        HockeyPeriod match = matchInfo.getMatch();
        return match.getGoals() != null;
    }

    @Override
    public boolean check(HockeyMatch hockeyMatch) {
        HockeyMatchInfo matchInfo = hockeyMatch.getMatchInfo();
        HockeyPeriod match = matchInfo.getMatch();
        Set<HockeyGoal> goals = match.getGoals();
        List<HockeyGoal> goalList = goals.stream().sorted(HockeyGoal.byTime).collect(Collectors.toList());
        int counter = 0;
        for (HockeyGoal hockeyGoal : goalList) {
            if (hockeyGoal.getWhoScored() == Who.HOME) {
                counter++;
            } else if (hockeyGoal.getWhoScored() == Who.GUEST) {
                counter = 0;
            }
            if (counter == n) {
                return true;
            }
        }
        return false;
    }
}
