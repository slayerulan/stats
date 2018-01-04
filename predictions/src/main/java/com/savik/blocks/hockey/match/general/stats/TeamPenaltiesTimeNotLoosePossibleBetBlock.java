package com.savik.blocks.hockey.match.general.stats;


import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.PossibleBetContainer;
import com.savik.bets.hockey.stats.TeamPenaltiesTimeNotLoosePossibleBet;
import com.savik.hockey.model.HockeyMatch;

public class TeamPenaltiesTimeNotLoosePossibleBetBlock extends PossibleBetContainer<HockeyMatch> {
    public TeamPenaltiesTimeNotLoosePossibleBetBlock(MatchData homeMatchData, MatchData guestMatchData) {
        super(
                new TeamPenaltiesTimeNotLoosePossibleBet(
                        homeMatchData, guestMatchData, HockeyMatch.MATCH
                ), ContainerType.TEAM_MINOR_PENALTIES_TIME_NOT_LOOSE
        );
    }
}
