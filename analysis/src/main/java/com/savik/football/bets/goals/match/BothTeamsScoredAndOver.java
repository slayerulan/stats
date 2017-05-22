package com.savik.football.bets.goals.match;

import com.savik.football.bets.GeneralBet;
import com.savik.football.bets.total.over.match.MatchOver;
import com.savik.football.model.Match;

public class BothTeamsScoredAndOver extends GeneralBet {

    private BothTeamsScored bothTeamsScored;

    private MatchOver matchOver;

    public BothTeamsScoredAndOver(double amount) {
        bothTeamsScored = new BothTeamsScored();
        matchOver = new MatchOver(amount);
    }

    @Override
    public boolean canAnalyze(Match match) {
        return bothTeamsScored.canAnalyze(match) && matchOver.canAnalyze(match);
    }

    @Override
    public boolean check(Match match) {
        return bothTeamsScored.check(match) && matchOver.check(match);
    }
}
