package com.savik.blocks.football.match.cards.match;


import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.Period;
import com.savik.PossibleBetContainer;
import com.savik.football.model.FootballMatch;

import java.util.Arrays;
import java.util.function.Function;

public class PossibleBetsMatchCardsBlock extends PossibleBetContainer<FootballMatch> {
    public PossibleBetsMatchCardsBlock(MatchData homeMatchData, MatchData guestMatchData,
                                       Function<FootballMatch, Period> period, ContainerType periodType) {
        super(Arrays.asList(
                new YellowCardsWDTotalOverPossibleBetBlock(period),
                new YellowCardsWDTotalUnderPossibleBetBlock(period),
                new TeamYellowCardsWDTotalOverPossibleBetBlock(homeMatchData, guestMatchData, period),
                new OpposingTeamYellowCardsWDTotalOverPossibleBetBlock(homeMatchData, guestMatchData, period),
                new TeamYellowCardsWDNotLoosePossibleBetBlock(homeMatchData, guestMatchData, period),
                new OpposingTeamYellowCardsWDNotLoosePossibleBetBlock(homeMatchData, guestMatchData, period),
                new TeamYellowCardsWDHandicapPossibleBetBlock(homeMatchData, guestMatchData, period),
                new OpposingTeamYellowCardsWDHandicapPossibleBetBlock(homeMatchData, guestMatchData, period)
        ), periodType);
    }
}
