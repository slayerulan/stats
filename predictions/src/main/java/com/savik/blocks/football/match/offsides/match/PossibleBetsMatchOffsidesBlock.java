package com.savik.blocks.football.match.offsides.match;


import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.PossibleBetContainer;
import com.savik.football.model.FootballMatch;

import java.util.Arrays;

public class PossibleBetsMatchOffsidesBlock extends PossibleBetContainer<FootballMatch> {
    public PossibleBetsMatchOffsidesBlock(MatchData homeMatchData, MatchData guestMatchData) {
        super(Arrays.asList(
                new OffsidesTotalOverPossibleBetBlock(),
                new OffsidesTotalUnderPossibleBetBlock(),
                new TeamOffsidesTotalOverPossibleBetBlock(homeMatchData, guestMatchData),
                new OpposingTeamOffsidesTotalOverPossibleBetBlock(homeMatchData, guestMatchData),
                new TeamOffsidesNotLoosePossibleBetBlock(homeMatchData, guestMatchData),
                new OpposingTeamOffsidesNotLoosePossibleBetBlock(homeMatchData, guestMatchData),
                new TeamOffsidesHandicapPossibleBetBlock(homeMatchData, guestMatchData),
                new OpposingTeamOffsidesHandicapPossibleBetBlock(homeMatchData, guestMatchData)
        ), ContainerType.MATCH);
    }
}
