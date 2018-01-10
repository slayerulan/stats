package com.savik.blocks.football.match.offsides.match;


import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.PossibleBetContainer;
import com.savik.bets.football.offsides.PeriodOpposingTeamOffsidesNotLoosePossibleBet;
import com.savik.football.model.FootballMatch;

public class OpposingTeamOffsidesNotLoosePossibleBetBlock extends PossibleBetContainer<FootballMatch> {
    public OpposingTeamOffsidesNotLoosePossibleBetBlock(MatchData homeMatchData, MatchData guestMatchData) {
        super(
                new PeriodOpposingTeamOffsidesNotLoosePossibleBet(
                        homeMatchData, guestMatchData, FootballMatch.MATCH
                ), ContainerType.OPPOSING_TEAM_NOT_LOOSE
        );
    }
}
