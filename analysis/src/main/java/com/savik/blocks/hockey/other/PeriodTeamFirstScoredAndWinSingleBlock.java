package com.savik.blocks.hockey.other;

import com.savik.GeneralTeamBetContainer;
import com.savik.MatchData;
import com.savik.bets.hockey.other.GuestScoredFirstAndWin;
import com.savik.bets.hockey.other.HomeScoredFirstAndWin;
import com.savik.hockey.model.HockeyMatch;

public class PeriodTeamFirstScoredAndWinSingleBlock extends GeneralTeamBetContainer<HockeyMatch> {

    public PeriodTeamFirstScoredAndWinSingleBlock(MatchData matchData) {
        super(
                new HomeScoredFirstAndWin(),
                new GuestScoredFirstAndWin(),
                matchData
        );
    }

    public PeriodTeamFirstScoredAndWinSingleBlock() {
        this(null);
    }

}
