package com.savik.blocks.football.match.corners.match;


import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.PossibleBetContainer;
import com.savik.bets.football.corners.PeriodOpposingTeamCornersNotLoosePossibleBet;
import com.savik.football.model.FootballMatch;

public class OpposingTeamCornersNotLoosePossibleBetBlock extends PossibleBetContainer<FootballMatch> {
    public OpposingTeamCornersNotLoosePossibleBetBlock(MatchData homeMatchData, MatchData guestMatchData) {
        super(
                new PeriodOpposingTeamCornersNotLoosePossibleBet(
                        homeMatchData, guestMatchData, FootballMatch.MATCH
                ), ContainerType.OPPOSING_TEAM_NOT_LOOSE
        );
    }
}
