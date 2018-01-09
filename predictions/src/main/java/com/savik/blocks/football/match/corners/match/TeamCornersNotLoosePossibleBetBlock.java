package com.savik.blocks.football.match.corners.match;


import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.PossibleBetContainer;
import com.savik.bets.football.corners.PeriodTeamCornersNotLoosePossibleBet;
import com.savik.football.model.FootballMatch;

public class TeamCornersNotLoosePossibleBetBlock extends PossibleBetContainer<FootballMatch> {
    public TeamCornersNotLoosePossibleBetBlock(MatchData homeMatchData, MatchData guestMatchData) {
        super(
                new PeriodTeamCornersNotLoosePossibleBet(
                        homeMatchData, guestMatchData, FootballMatch.MATCH
                ), ContainerType.TEAM_NOT_LOOSE
        );
    }
}
