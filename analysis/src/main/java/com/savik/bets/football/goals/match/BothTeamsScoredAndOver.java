package com.savik.bets.football.goals.match;

import com.savik.GeneralBet;
import com.savik.bets.general.goals.PeriodBothTeamsScored;
import com.savik.bets.general.total.over.PeriodOver;
import com.savik.football.model.FootballMatch;
import lombok.*;

@Getter
public class BothTeamsScoredAndOver extends GeneralBet<FootballMatch> {

    private PeriodBothTeamsScored bothTeamsScored;

    private PeriodOver matchOver;

    public BothTeamsScoredAndOver(double amount) {
        bothTeamsScored = new PeriodBothTeamsScored();
        matchOver = new PeriodOver(amount);
    }

    @Override
    public boolean canAnalyze(FootballMatch footballMatch) {
        return bothTeamsScored.canAnalyze(footballMatch.getMatchInfo().getMatch()) &&
               matchOver.canAnalyze(footballMatch.getMatchInfo().getMatch());
    }

    @Override
    public boolean check(FootballMatch footballMatch) {
        return bothTeamsScored.check(footballMatch.getMatchInfo().getMatch()) &&
               matchOver.check(footballMatch.getMatchInfo().getMatch());
    }
}
