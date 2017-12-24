package com.savik.blocks.hockey.other;

import com.savik.ContainerType;
import com.savik.GeneralTeamBetContainer;
import com.savik.MatchData;
import com.savik.bets.hockey.other.GuestScoredFirstAndWin;
import com.savik.bets.hockey.other.GuestScoredNInRow;
import com.savik.bets.hockey.other.HomeScoredFirstAndWin;
import com.savik.bets.hockey.other.HomeScoredNInRow;
import com.savik.hockey.model.HockeyMatch;

public class PeriodTeamScoredNInRowSingleBlock extends GeneralTeamBetContainer<HockeyMatch> {

    public PeriodTeamScoredNInRowSingleBlock(int n, MatchData matchData) {
        this(n, matchData, null);
    }

    public PeriodTeamScoredNInRowSingleBlock(int n, MatchData matchData, ContainerType type) {
        super(
                new HomeScoredNInRow(n),
                new GuestScoredNInRow(n),
                type,
                matchData
        );
    }

}
