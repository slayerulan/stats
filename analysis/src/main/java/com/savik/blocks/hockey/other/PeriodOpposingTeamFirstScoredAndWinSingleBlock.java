package com.savik.blocks.hockey.other;

import com.savik.ContainerType;
import com.savik.GeneralTeamBetContainer;
import com.savik.MatchData;
import com.savik.bets.hockey.other.GuestScoredFirstAndWin;
import com.savik.bets.hockey.other.HomeScoredFirstAndWin;
import com.savik.hockey.model.HockeyMatch;

public class PeriodOpposingTeamFirstScoredAndWinSingleBlock extends GeneralTeamBetContainer<HockeyMatch> {

    public PeriodOpposingTeamFirstScoredAndWinSingleBlock(MatchData matchData) {
        this(matchData, null);
    }

    public PeriodOpposingTeamFirstScoredAndWinSingleBlock(MatchData matchData, ContainerType type) {
        super(
                new GuestScoredFirstAndWin(),
                new HomeScoredFirstAndWin(),
                type,
                matchData
        );
    }


}
