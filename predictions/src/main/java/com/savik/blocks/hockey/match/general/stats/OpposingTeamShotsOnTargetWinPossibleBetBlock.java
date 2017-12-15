package com.savik.blocks.hockey.match.general.stats;


import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.PossibleBetContainer;
import com.savik.bets.hockey.stats.OpposingTeamShotsOnTargetWinPossibleBet;
import com.savik.hockey.model.HockeyMatch;

public class OpposingTeamShotsOnTargetWinPossibleBetBlock extends PossibleBetContainer<HockeyMatch> {
    public OpposingTeamShotsOnTargetWinPossibleBetBlock(MatchData homeMatchData, MatchData guestMatchData) {
        super(
                new OpposingTeamShotsOnTargetWinPossibleBet(
                        homeMatchData, guestMatchData, HockeyMatch.MATCH
                ), ContainerType.OPPOSING_TEAM_SHOTS_ON_TARGET_WIN
        );
    }
}
