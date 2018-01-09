package com.savik.blocks.football.match.corners;


import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.PossibleBetContainer;
import com.savik.blocks.football.match.corners.match.PossibleBetsMatchCornersBlock;
import com.savik.football.model.FootballMatch;

import java.util.Arrays;

public class PossibleBetsCornersBlock extends PossibleBetContainer<FootballMatch> {
    public PossibleBetsCornersBlock(MatchData homeMatchData, MatchData guestMatchData) {
        super(Arrays.asList(
                new PossibleBetsMatchCornersBlock(homeMatchData, guestMatchData)
        ), ContainerType.CORNERS);
    }
}
