package com.savik.football.bets.goals.match;

import com.savik.football.bets.GeneralBet;
import com.savik.football.bets.total.over.first_period.FirstPeriodHomeOver;
import com.savik.football.bets.total.over.match.MatchGuestOver;
import com.savik.football.bets.total.over.match.MatchHomeOver;
import com.savik.football.bets.total.over.second_period.SecondPeriodHomeOver;
import com.savik.football.model.Match;
import lombok.*;

@Getter
public class BothTeamsScored extends GeneralBet {

    private MatchHomeOver matchHomeOver;

    private MatchGuestOver matchGuestOver;

    public BothTeamsScored() {
        matchHomeOver = new MatchHomeOver(0.5);
        matchGuestOver = new MatchGuestOver(0.5);
    }

    @Override
    public boolean canAnalyze(Match match) {
        return matchHomeOver.canAnalyze(match) && matchGuestOver.canAnalyze(match);
    }

    @Override
    public boolean check(Match match) {
        return matchHomeOver.check(match) && matchGuestOver.check(match);
    }
}
