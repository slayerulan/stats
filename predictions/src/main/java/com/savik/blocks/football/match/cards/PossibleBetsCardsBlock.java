package com.savik.blocks.football.match.cards;


import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.PossibleBetContainer;
import com.savik.blocks.football.match.corners.*;
import com.savik.football.model.FootballMatch;

import java.util.Arrays;

public class PossibleBetsCardsBlock extends PossibleBetContainer<FootballMatch> {
    public PossibleBetsCardsBlock(MatchData homeMatchData, MatchData guestMatchData) {
        super(Arrays.asList(
                new YellowCardsWDTotalOverPossibleBetBlock(),
                new YellowCardsWDTotalUnderPossibleBetBlock(),
                new TeamYellowCardsWDTotalOverPossibleBetBlock(homeMatchData, guestMatchData),
                new OpposingTeamYellowCardsWDTotalOverPossibleBetBlock(homeMatchData, guestMatchData),
                new TeamYellowCardsWDNotLoosePossibleBetBlock(homeMatchData, guestMatchData),
                new OpposingTeamYellowCardsWDNotLoosePossibleBetBlock(homeMatchData, guestMatchData),
                new TeamYellowCardsWDHandicapPossibleBetBlock(homeMatchData, guestMatchData),
                new OpposingTeamYellowCardsWDHandicapPossibleBetBlock(homeMatchData, guestMatchData)
        ), ContainerType.CARDS);
    }
}
