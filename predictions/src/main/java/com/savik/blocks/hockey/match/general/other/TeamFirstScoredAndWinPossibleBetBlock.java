package com.savik.blocks.hockey.match.general.other;


import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.PossibleBetContainer;
import com.savik.bets.hockey.other.TeamFirstScoredAndWinPossibleBet;
import com.savik.hockey.model.HockeyMatch;

class TeamFirstScoredAndWinPossibleBetBlock extends PossibleBetContainer<HockeyMatch> {
    public TeamFirstScoredAndWinPossibleBetBlock(MatchData homeMatchData, MatchData guestMatchData) {
        super(
                new TeamFirstScoredAndWinPossibleBet(homeMatchData, guestMatchData),
                ContainerType.TEAM_FIRST_SCORED_AND_WIN
        );
    }
}
