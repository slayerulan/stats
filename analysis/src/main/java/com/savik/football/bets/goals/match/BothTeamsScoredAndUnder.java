package com.savik.football.bets.goals.match;

import com.savik.football.bets.GeneralBet;
import com.savik.football.bets.goals.PeriodBothTeamsScored;
import com.savik.football.bets.total.under.PeriodUnder;
import com.savik.football.model.FootballMatch;
import lombok.*;

@Getter
public class BothTeamsScoredAndUnder extends GeneralBet<FootballMatch> {

    private PeriodBothTeamsScored bothTeamsScored;

    private PeriodUnder matchUnder;

    public BothTeamsScoredAndUnder(double amount) {
        bothTeamsScored = new PeriodBothTeamsScored();
        matchUnder = new PeriodUnder(amount);
    }

    @Override
    public boolean canAnalyze(FootballMatch footballMatch) {
        return bothTeamsScored.canAnalyze(footballMatch.getMatchInfo().getMatch()) &&
               matchUnder.canAnalyze(footballMatch.getMatchInfo().getMatch());
    }

    @Override
    public boolean check(FootballMatch footballMatch) {
        return bothTeamsScored.check(footballMatch.getMatchInfo().getMatch()) &&
               matchUnder.check(footballMatch.getMatchInfo().getMatch());
    }
}
