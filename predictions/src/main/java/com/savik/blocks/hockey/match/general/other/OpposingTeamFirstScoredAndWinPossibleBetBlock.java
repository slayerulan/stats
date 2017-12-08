package com.savik.blocks.hockey.match.general.other;


import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.PossibleBetContainer;
import com.savik.bets.hockey.other.OpposingTeamFirstScoredAndWinPossibleBet;
import com.savik.hockey.model.HockeyMatch;

class OpposingTeamFirstScoredAndWinPossibleBetBlock extends PossibleBetContainer<HockeyMatch> {
    public OpposingTeamFirstScoredAndWinPossibleBetBlock(MatchData homeMatchData, MatchData guestMatchData) {
        super(
                new OpposingTeamFirstScoredAndWinPossibleBet(homeMatchData, guestMatchData),
                ContainerType.OPPOSING_TEAM_FIRST_SCORED_AND_WIN
        );
    }
}
