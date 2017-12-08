package com.savik.blocks.hockey.other;

import com.savik.GeneralTeamBetContainer;
import com.savik.MatchData;
import com.savik.bets.hockey.other.GuestScoredFirstAndWin;
import com.savik.bets.hockey.other.HomeScoredFirstAndWin;
import com.savik.hockey.model.HockeyMatch;

public class PeriodOpposingTeamFirstScoredAndWinSingleBlock extends GeneralTeamBetContainer<HockeyMatch> {

    public PeriodOpposingTeamFirstScoredAndWinSingleBlock(MatchData matchData) {
        super(
                new GuestScoredFirstAndWin(),
                new HomeScoredFirstAndWin(),
                matchData
        );
    }

    public PeriodOpposingTeamFirstScoredAndWinSingleBlock() {
        this(null);
    }

}
