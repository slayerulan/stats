package com.savik.blocks.hockey.match.general.stats.penalties;


import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.PossibleBetContainer;
import com.savik.bets.hockey.stats.OpposingTeamPenaltiesTimeNotLoosePossibleBet;
import com.savik.hockey.model.HockeyMatch;

public class OpposingTeamMinorPenaltiesTimeNotLoosePossibleBetBlock extends PossibleBetContainer<HockeyMatch> {
    public OpposingTeamMinorPenaltiesTimeNotLoosePossibleBetBlock(MatchData homeMatchData, MatchData guestMatchData) {
        super(
                new OpposingTeamPenaltiesTimeNotLoosePossibleBet(
                        homeMatchData, guestMatchData, HockeyMatch.MATCH
                ), ContainerType.OPPOSING_TEAM_MINOR_PENALTIES_TIME_NOT_LOOSE
        );
    }
}
