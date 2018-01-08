package com.savik.blocks.football.match.cards;


import com.savik.ContainerType;
import com.savik.PossibleBetContainer;
import com.savik.bets.football.cards.PeriodYellowCardsWDTotalOverPossibleBet;
import com.savik.bets.football.cards.PeriodYellowCardsWDTotalUnderPossibleBet;
import com.savik.football.model.FootballMatch;

import java.util.Arrays;

public class YellowCardsWDTotalUnderPossibleBetBlock extends PossibleBetContainer<FootballMatch> {
    public YellowCardsWDTotalUnderPossibleBetBlock() {
        super(Arrays.asList(
                new PossibleBetContainer<>(
                        new PeriodYellowCardsWDTotalUnderPossibleBet(FootballMatch.MATCH, 3.5),
                        ContainerType.UNDER_3_5
                ),
                new PossibleBetContainer<>(
                        new PeriodYellowCardsWDTotalUnderPossibleBet(FootballMatch.MATCH, 4.5),
                        ContainerType.UNDER_4_5
                ),
                new PossibleBetContainer<>(
                        new PeriodYellowCardsWDTotalUnderPossibleBet(FootballMatch.MATCH, 5.5),
                        ContainerType.UNDER_5_5
                ),
                new PossibleBetContainer<>(
                        new PeriodYellowCardsWDTotalUnderPossibleBet(FootballMatch.MATCH, 6.5),
                        ContainerType.UNDER_6_5
                ),
                new PossibleBetContainer<>(
                        new PeriodYellowCardsWDTotalUnderPossibleBet(FootballMatch.MATCH, 7.5),
                        ContainerType.UNDER_7_5
                )
                ), ContainerType.TOTAL_UNDER
        );
    }
}
