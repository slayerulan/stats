package com.savik.blocks.hockey.other;

import com.savik.ContainerType;
import com.savik.GeneralTeamBetContainer;
import com.savik.MatchData;
import com.savik.bets.hockey.other.GuestScoredNInRow;
import com.savik.bets.hockey.other.HomeScoredNInRow;
import com.savik.hockey.model.HockeyMatch;

public class PeriodOpposingTeamScoredNInRowSingleBlock extends GeneralTeamBetContainer<HockeyMatch> {

    public PeriodOpposingTeamScoredNInRowSingleBlock(int n, MatchData matchData) {
        this(n, matchData, null);
    }

    public PeriodOpposingTeamScoredNInRowSingleBlock(int n, MatchData matchData, ContainerType type) {
        super(
                new GuestScoredNInRow(n),
                new HomeScoredNInRow(n),
                type,
                matchData
        );
    }

}
