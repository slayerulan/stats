package com.savik.football.bets.goals.match;

import com.savik.football.bets.GeneralBet;
import com.savik.football.bets.total.over.PeriodOver;
import com.savik.football.model.FootballMatch;
import lombok.*;

@Getter
public class BothTeamsScoredAndOver extends GeneralBet {

    private BothTeamsScored bothTeamsScored;

    private PeriodOver matchOver;

    public BothTeamsScoredAndOver(double amount) {
        bothTeamsScored = new BothTeamsScored();
        matchOver = new PeriodOver(amount);
    }

    @Override
    public boolean canAnalyze(FootballMatch footballMatch) {
        return bothTeamsScored.canAnalyze(footballMatch) &&
               matchOver.canAnalyze(footballMatch.getMatchInfo().getMatch());
    }

    @Override
    public boolean check(FootballMatch footballMatch) {
        return bothTeamsScored.check(footballMatch) && matchOver.check(footballMatch.getMatchInfo().getMatch());
    }
}
