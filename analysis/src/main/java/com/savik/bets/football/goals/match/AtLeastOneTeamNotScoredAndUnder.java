package com.savik.bets.football.goals.match;

import com.savik.GeneralBet;
import com.savik.bets.general.goals.PeriodBothTeamsScored;
import com.savik.bets.general.total.under.PeriodUnder;
import com.savik.football.model.FootballMatch;
import lombok.*;

@Getter
public class AtLeastOneTeamNotScoredAndUnder extends GeneralBet<FootballMatch> {

    private PeriodBothTeamsScored bothTeamsScored;

    private PeriodUnder matchUnder;

    public AtLeastOneTeamNotScoredAndUnder(double amount) {
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
        return !bothTeamsScored.check(footballMatch.getMatchInfo().getMatch()) &&
               matchUnder.check(footballMatch.getMatchInfo().getMatch());
    }
}
