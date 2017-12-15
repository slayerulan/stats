package com.savik.blocks.hockey.match.general.stats;


import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.PossibleBetContainer;
import com.savik.bets.hockey.stats.TeamShotsOnTargetWinPossibleBet;
import com.savik.hockey.model.HockeyMatch;

public class TeamShotsOnTargetWinPossibleBetBlock extends PossibleBetContainer<HockeyMatch> {
    public TeamShotsOnTargetWinPossibleBetBlock(MatchData homeMatchData, MatchData guestMatchData) {
        super(
                new TeamShotsOnTargetWinPossibleBet(
                        homeMatchData, guestMatchData, HockeyMatch.MATCH
                ), ContainerType.TEAM_SHOTS_ON_TARGET_WIN
        );
    }
}
