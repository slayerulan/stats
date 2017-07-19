package com.savik.football.bets.goals.match;

import com.savik.football.bets.GeneralBet;
import com.savik.football.bets.total.over.PeriodGuestOver;
import com.savik.football.bets.total.over.PeriodHomeOver;
import com.savik.football.model.FootballMatch;
import lombok.*;

@Getter
public class BothTeamsScored extends GeneralBet {

    private PeriodHomeOver matchHomeOver;

    private PeriodGuestOver matchGuestOver;

    public BothTeamsScored() {
        matchHomeOver = new PeriodHomeOver(0.5);
        matchGuestOver = new PeriodGuestOver(0.5);
    }

    @Override
    public boolean canAnalyze(FootballMatch footballMatch) {
        return matchHomeOver.canAnalyze(footballMatch.getMatchInfo().getMatch()) &&
               matchGuestOver.canAnalyze(footballMatch.getMatchInfo().getMatch());
    }

    @Override
    public boolean check(FootballMatch footballMatch) {
        return matchHomeOver.check(footballMatch.getMatchInfo().getMatch())
               && matchGuestOver.check(footballMatch.getMatchInfo().getMatch());
    }
}
