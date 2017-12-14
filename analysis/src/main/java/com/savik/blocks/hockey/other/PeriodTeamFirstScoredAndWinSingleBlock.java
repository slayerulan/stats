package com.savik.blocks.hockey.other;

import com.savik.ContainerType;
import com.savik.GeneralTeamBetContainer;
import com.savik.MatchData;
import com.savik.bets.hockey.other.GuestScoredFirstAndWin;
import com.savik.bets.hockey.other.HomeScoredFirstAndWin;
import com.savik.hockey.model.HockeyMatch;

public class PeriodTeamFirstScoredAndWinSingleBlock extends GeneralTeamBetContainer<HockeyMatch> {

    public PeriodTeamFirstScoredAndWinSingleBlock(MatchData matchData) {
        this(matchData, null);
    }

    public PeriodTeamFirstScoredAndWinSingleBlock(MatchData matchData, ContainerType type) {
        super(
                new HomeScoredFirstAndWin(),
                new GuestScoredFirstAndWin(),
                type,
                matchData
        );
    }

}
