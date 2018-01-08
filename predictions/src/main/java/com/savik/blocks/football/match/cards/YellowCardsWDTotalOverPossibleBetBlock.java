package com.savik.blocks.football.match.cards;


import com.savik.ContainerType;
import com.savik.PossibleBetContainer;
import com.savik.bets.football.cards.PeriodYellowCardsWDTotalOverPossibleBet;
import com.savik.bets.football.corners.PeriodCornersTotalOverPossibleBet;
import com.savik.football.model.FootballMatch;

import java.util.Arrays;

public class YellowCardsWDTotalOverPossibleBetBlock extends PossibleBetContainer<FootballMatch> {
    public YellowCardsWDTotalOverPossibleBetBlock() {
        super(Arrays.asList(
                new PossibleBetContainer<>(
                        new PeriodYellowCardsWDTotalOverPossibleBet(FootballMatch.MATCH, 3.5),
                        ContainerType.OVER_3_5
                ),
                new PossibleBetContainer<>(
                        new PeriodYellowCardsWDTotalOverPossibleBet(FootballMatch.MATCH, 4.5),
                        ContainerType.OVER_4_5
                ),
                new PossibleBetContainer<>(
                        new PeriodYellowCardsWDTotalOverPossibleBet(FootballMatch.MATCH, 5.5),
                        ContainerType.OVER_5_5
                ),
                new PossibleBetContainer<>(
                        new PeriodYellowCardsWDTotalOverPossibleBet(FootballMatch.MATCH, 6.5),
                        ContainerType.OVER_6_5
                )
                ), ContainerType.TOTAL_OVER
        );
    }
}
