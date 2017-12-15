package com.savik.blocks.hockey.match.general.stats;


import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.PossibleBetContainer;
import com.savik.bets.hockey.stats.TeamPenaltiesTimeWinPossibleBet;
import com.savik.hockey.model.HockeyMatch;

public class TeamPenaltiesTimeWinPossibleBetBlock extends PossibleBetContainer<HockeyMatch> {
    public TeamPenaltiesTimeWinPossibleBetBlock(MatchData homeMatchData, MatchData guestMatchData) {
        super(
                new TeamPenaltiesTimeWinPossibleBet(
                        homeMatchData, guestMatchData, HockeyMatch.MATCH
                ), ContainerType.TEAM_PENALTIES_TIME_WIN
        );
    }
}
