package com.savik.football.bets.goals.match;

import com.savik.football.bets.GeneralBet;
import com.savik.football.bets.total.under.PeriodUnder;
import com.savik.football.model.FootballMatch;
import lombok.*;

@Getter
public class BothTeamsScoredAndUnder extends GeneralBet {

    private BothTeamsScored bothTeamsScored;

    private PeriodUnder matchUnder;

    public BothTeamsScoredAndUnder(double amount) {
        bothTeamsScored = new BothTeamsScored();
        matchUnder = new PeriodUnder(amount);
    }

    @Override
    public boolean canAnalyze(FootballMatch footballMatch) {
        return bothTeamsScored.canAnalyze(footballMatch)
               && matchUnder.canAnalyze(footballMatch.getMatchInfo().getMatch());
    }

    @Override
    public boolean check(FootballMatch footballMatch) {
        return bothTeamsScored.check(footballMatch) && matchUnder.check(footballMatch.getMatchInfo().getMatch());
    }
}
