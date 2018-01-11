package com.savik.blocks.football.match.cards;


import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.PossibleBetContainer;
import com.savik.blocks.football.match.cards.match.PossibleBetsMatchCardsBlock;
import com.savik.blocks.football.match.corners.*;
import com.savik.football.model.FootballMatch;

import java.util.Arrays;

public class PossibleBetsCardsBlock extends PossibleBetContainer<FootballMatch> {
    public PossibleBetsCardsBlock(MatchData homeMatchData, MatchData guestMatchData) {
        super(Arrays.asList(
                new PossibleBetsMatchCardsBlock(homeMatchData, guestMatchData, FootballMatch.MATCH, ContainerType.MATCH),
                new PossibleBetsMatchCardsBlock(homeMatchData, guestMatchData, FootballMatch.FIRST_PERIOD, ContainerType.FIRST_PERIOD),
                new PossibleBetsMatchCardsBlock(homeMatchData, guestMatchData, FootballMatch.SECOND_PERIOD, ContainerType.SECOND_PERIOD)
        ), ContainerType.CARDS);
    }
}
