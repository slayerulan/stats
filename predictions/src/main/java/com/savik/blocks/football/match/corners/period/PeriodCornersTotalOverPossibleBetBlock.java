package com.savik.blocks.football.match.corners.period;


import com.savik.ContainerType;
import com.savik.Period;
import com.savik.PossibleBetContainer;
import com.savik.bets.football.corners.PeriodCornersTotalOverPossibleBet;
import com.savik.football.model.FootballMatch;

import java.util.Arrays;
import java.util.function.Function;

public class PeriodCornersTotalOverPossibleBetBlock extends PossibleBetContainer<FootballMatch> {
    public PeriodCornersTotalOverPossibleBetBlock(Function<FootballMatch, Period> period) {
        super(Arrays.asList(
                new PossibleBetContainer<>(
                        new PeriodCornersTotalOverPossibleBet(period, 3.5),
                        ContainerType.OVER_3_5
                ),
                new PossibleBetContainer<>(
                        new PeriodCornersTotalOverPossibleBet(period, 4.5),
                        ContainerType.OVER_4_5
                ),
                new PossibleBetContainer<>(
                        new PeriodCornersTotalOverPossibleBet(period, 5.5),
                        ContainerType.OVER_5_5
                ),
                new PossibleBetContainer<>(
                        new PeriodCornersTotalOverPossibleBet(period, 6.5),
                        ContainerType.OVER_6_5
                )
                ), ContainerType.TOTAL_OVER
        );
    }
}