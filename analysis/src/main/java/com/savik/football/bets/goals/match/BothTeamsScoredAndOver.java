package com.savik.football.bets.goals.match;

import com.savik.football.bets.GeneralBet;
import com.savik.football.bets.total.over.match.MatchOver;
import com.savik.football.model.FootballMatch;
import lombok.*;

@Getter
public class BothTeamsScoredAndOver extends GeneralBet {

    private BothTeamsScored bothTeamsScored;

    private MatchOver matchOver;

    public BothTeamsScoredAndOver(double amount) {
        bothTeamsScored = new BothTeamsScored();
        matchOver = new MatchOver(amount);
    }

    @Override
    public boolean canAnalyze(FootballMatch footballMatch) {
        return bothTeamsScored.canAnalyze(footballMatch) && matchOver.canAnalyze(footballMatch);
    }

    @Override
    public boolean check(FootballMatch footballMatch) {
        return bothTeamsScored.check(footballMatch) && matchOver.check(footballMatch);
    }
}
