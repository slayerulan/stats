package com.savik.blocks.football.match.corners;


import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.PossibleBetContainer;
import com.savik.football.model.FootballMatch;

import java.util.Arrays;

public class PossibleBetsCornersBlock extends PossibleBetContainer<FootballMatch> {
    public PossibleBetsCornersBlock(MatchData homeMatchData, MatchData guestMatchData) {
        super(Arrays.asList(
                new CornersTotalOverPossibleBetBlock(),
                new CornersTotalUnderPossibleBetBlock(),
                new TeamCornersTotalOverPossibleBetBlock(homeMatchData, guestMatchData),
                new OpposingTeamCornersTotalOverPossibleBetBlock(homeMatchData, guestMatchData),
                new TeamCornersNotLoosePossibleBetBlock(homeMatchData, guestMatchData),
                new OpposingTeamCornersNotLoosePossibleBetBlock(homeMatchData, guestMatchData),
                new TeamCornersHandicapPossibleBetBlock(homeMatchData, guestMatchData),
                new OpposingTeamCornersHandicapPossibleBetBlock(homeMatchData, guestMatchData)
        ), ContainerType.CORNERS);
    }
}
