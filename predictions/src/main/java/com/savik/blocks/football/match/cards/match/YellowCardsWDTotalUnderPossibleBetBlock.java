package com.savik.blocks.football.match.cards.match;


import com.savik.ContainerType;
import com.savik.Period;
import com.savik.PossibleBetContainer;
import com.savik.bets.football.cards.PeriodYellowCardsWDTotalUnderPossibleBet;
import com.savik.football.model.FootballMatch;

import java.util.Arrays;
import java.util.function.Function;

public class YellowCardsWDTotalUnderPossibleBetBlock extends PossibleBetContainer<FootballMatch> {
    public YellowCardsWDTotalUnderPossibleBetBlock(Function<FootballMatch, Period> period) {
        super(Arrays.asList(
                new PossibleBetContainer<>(
                        new PeriodYellowCardsWDTotalUnderPossibleBet(period, 3.5),
                        ContainerType.UNDER_3_5
                ),
                new PossibleBetContainer<>(
                        new PeriodYellowCardsWDTotalUnderPossibleBet(period, 4.5),
                        ContainerType.UNDER_4_5
                ),
                new PossibleBetContainer<>(
                        new PeriodYellowCardsWDTotalUnderPossibleBet(period, 5.5),
                        ContainerType.UNDER_5_5
                ),
                new PossibleBetContainer<>(
                        new PeriodYellowCardsWDTotalUnderPossibleBet(period, 6.5),
                        ContainerType.UNDER_6_5
                ),
                new PossibleBetContainer<>(
                        new PeriodYellowCardsWDTotalUnderPossibleBet(period, 7.5),
                        ContainerType.UNDER_7_5
                )
                ), ContainerType.TOTAL_UNDER
        );
    }
}
