package com.savik.football.bets.goals.match;

import com.savik.football.bets.GeneralBet;
import com.savik.football.bets.total.over.match.MatchGuestOver;
import com.savik.football.bets.total.over.match.MatchHomeOver;
import com.savik.football.model.FootballMatch;
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
    public boolean canAnalyze(FootballMatch footballMatch) {
        return matchHomeOver.canAnalyze(footballMatch) && matchGuestOver.canAnalyze(footballMatch);
    }

    @Override
    public boolean check(FootballMatch footballMatch) {
        return matchHomeOver.check(footballMatch) && matchGuestOver.check(footballMatch);
    }
}
