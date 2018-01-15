package com.savik.blocks.football.match.corners.match;


import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.PossibleBetContainer;
import com.savik.blocks.football.match.corners.*;
import com.savik.football.model.FootballMatch;

import java.util.Arrays;

public class PossibleBetsMatchCornersBlock extends PossibleBetContainer<FootballMatch> {
    public PossibleBetsMatchCornersBlock(MatchData homeMatchData, MatchData guestMatchData) {
        super(Arrays.asList(
                new CornersTotalOverPossibleBetBlock(),
                new CornersTotalUnderPossibleBetBlock(),
                new TeamCornersTotalOverPossibleBetBlock(homeMatchData, guestMatchData, FootballMatch.MATCH),
                new OpposingTeamCornersTotalOverPossibleBetBlock(homeMatchData, guestMatchData, FootballMatch.MATCH),
                new TeamCornersNotLoosePossibleBetBlock(homeMatchData, guestMatchData, FootballMatch.MATCH),
                new OpposingTeamCornersNotLoosePossibleBetBlock(homeMatchData, guestMatchData, FootballMatch.MATCH),
                new TeamCornersHandicapPossibleBetBlock(homeMatchData, guestMatchData, FootballMatch.MATCH),
                new OpposingTeamCornersHandicapPossibleBetBlock(homeMatchData, guestMatchData, FootballMatch.MATCH)
        ), ContainerType.MATCH);
    }
}
