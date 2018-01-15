package com.savik.blocks.football.match.cards.match;


import com.savik.ContainerType;
import com.savik.Period;
import com.savik.PossibleBetContainer;
import com.savik.bets.football.cards.PeriodYellowCardsWDTotalOverPossibleBet;
import com.savik.football.model.FootballMatch;

import java.util.Arrays;
import java.util.function.Function;

public class YellowCardsWDTotalOverPossibleBetBlock extends PossibleBetContainer<FootballMatch> {
    public YellowCardsWDTotalOverPossibleBetBlock(Function<FootballMatch, Period> period) {
        super(Arrays.asList(
                new PossibleBetContainer<>(
                        new PeriodYellowCardsWDTotalOverPossibleBet(period, 1.5),
                        ContainerType.OVER_1_5
                ),
                new PossibleBetContainer<>(
                        new PeriodYellowCardsWDTotalOverPossibleBet(period, 2.5),
                        ContainerType.OVER_2_5
                ),
                new PossibleBetContainer<>(
                        new PeriodYellowCardsWDTotalOverPossibleBet(period, 3.5),
                        ContainerType.OVER_3_5
                ),
                new PossibleBetContainer<>(
                        new PeriodYellowCardsWDTotalOverPossibleBet(period, 4.5),
                        ContainerType.OVER_4_5
                ),
                new PossibleBetContainer<>(
                        new PeriodYellowCardsWDTotalOverPossibleBet(period, 5.5),
                        ContainerType.OVER_5_5
                ),
                new PossibleBetContainer<>(
                        new PeriodYellowCardsWDTotalOverPossibleBet(period, 6.5),
                        ContainerType.OVER_6_5
                )
                ), ContainerType.TOTAL_OVER
        );
    }
}
