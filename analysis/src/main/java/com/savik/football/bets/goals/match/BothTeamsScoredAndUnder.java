package com.savik.football.bets.goals.match;

import com.savik.football.bets.GeneralBet;
import com.savik.football.bets.total.over.match.MatchOver;
import com.savik.football.bets.total.under.match.MatchUnder;
import com.savik.football.model.Match;

public class BothTeamsScoredAndUnder extends GeneralBet {

    private BothTeamsScored bothTeamsScored;

    private MatchUnder matchUnder;

    public BothTeamsScoredAndUnder(int amount) {
        bothTeamsScored = new BothTeamsScored();
        matchUnder = new MatchUnder(amount);
    }

    @Override
    public boolean canAnalyze(Match match) {
        return bothTeamsScored.canAnalyze(match) && matchUnder.canAnalyze(match);
    }

    @Override
    public boolean check(Match match) {
        return bothTeamsScored.check(match) && matchUnder.check(match);
    }
}