package com.savik.blocks.football.match.offsides;


import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.PossibleBetContainer;
import com.savik.blocks.football.match.offsides.match.PossibleBetsMatchOffsidesBlock;
import com.savik.football.model.FootballMatch;

import java.util.Arrays;

public class PossibleBetsOffsidesBlock extends PossibleBetContainer<FootballMatch> {
    public PossibleBetsOffsidesBlock(MatchData homeMatchData, MatchData guestMatchData) {
        super(Arrays.asList(
                new PossibleBetsMatchOffsidesBlock(homeMatchData, guestMatchData)
        ), ContainerType.OFFSIDES);
    }
}
