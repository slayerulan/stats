package com.savik.football.bets.goals.match;

import com.savik.football.bets.GeneralBet;
import com.savik.football.bets.total.under.match.MatchUnder;
import com.savik.football.model.FootballMatch;
import lombok.*;

@Getter
public class AtLeastOneTeamNotScoredAndUnder extends GeneralBet {

    private BothTeamsScored bothTeamsScored;

    private MatchUnder matchUnder;

    public AtLeastOneTeamNotScoredAndUnder(double amount) {
        bothTeamsScored = new BothTeamsScored();
        matchUnder = new MatchUnder(amount);
    }

    @Override
    public boolean canAnalyze(FootballMatch footballMatch) {
        return bothTeamsScored.canAnalyze(footballMatch) && matchUnder.canAnalyze(footballMatch);
    }

    @Override
    public boolean check(FootballMatch footballMatch) {
        return !bothTeamsScored.check(footballMatch) && matchUnder.check(footballMatch);
    }
}
