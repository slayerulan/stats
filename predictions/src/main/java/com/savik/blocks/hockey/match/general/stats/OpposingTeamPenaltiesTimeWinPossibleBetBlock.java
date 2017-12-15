package com.savik.blocks.hockey.match.general.stats;


import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.PossibleBetContainer;
import com.savik.bets.hockey.stats.OpposingTeamPenaltiesTimeWinPossibleBet;
import com.savik.hockey.model.HockeyMatch;

public class OpposingTeamPenaltiesTimeWinPossibleBetBlock extends PossibleBetContainer<HockeyMatch> {
    public OpposingTeamPenaltiesTimeWinPossibleBetBlock(MatchData homeMatchData, MatchData guestMatchData) {
        super(
                new OpposingTeamPenaltiesTimeWinPossibleBet(
                        homeMatchData, guestMatchData, HockeyMatch.MATCH
                ), ContainerType.OPPOSING_TEAM_PENALTIES_TIME_WIN
        );
    }
}
