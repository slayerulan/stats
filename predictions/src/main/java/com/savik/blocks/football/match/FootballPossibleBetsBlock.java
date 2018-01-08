package com.savik.blocks.football.match;


import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.PossibleBetContainer;
import com.savik.blocks.football.match.corners.PossibleBetsCornersBlock;
import com.savik.football.model.FootballMatch;

import java.util.Arrays;

public class FootballPossibleBetsBlock extends PossibleBetContainer<FootballMatch> {
    public FootballPossibleBetsBlock(MatchData homeMatchData, MatchData guestMatchData) {
        super(Arrays.asList(
            new PossibleBetsCornersBlock(homeMatchData, guestMatchData)
        ), ContainerType.ROOT);
    }
}
