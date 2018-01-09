package com.savik.blocks.football.match.corners.period;


import com.savik.ContainerType;
import com.savik.Period;
import com.savik.PossibleBetContainer;
import com.savik.bets.football.corners.PeriodCornersTotalUnderPossibleBet;
import com.savik.football.model.FootballMatch;

import java.util.Arrays;
import java.util.function.Function;

public class PeriodCornersTotalUnderPossibleBetBlock extends PossibleBetContainer<FootballMatch> {
    public PeriodCornersTotalUnderPossibleBetBlock(Function<FootballMatch, Period> period) {
        super(Arrays.asList(
                new PossibleBetContainer<>(
                        new PeriodCornersTotalUnderPossibleBet(period, 3.5),
                        ContainerType.UNDER_3_5
                ),
                new PossibleBetContainer<>(
                        new PeriodCornersTotalUnderPossibleBet(period, 4.5),
                        ContainerType.UNDER_4_5
                ),
                new PossibleBetContainer<>(
                        new PeriodCornersTotalUnderPossibleBet(period, 5.5),
                        ContainerType.UNDER_5_5
                ),
                new PossibleBetContainer<>(
                        new PeriodCornersTotalUnderPossibleBet(period, 6.5),
                        ContainerType.UNDER_6_5
                )
                ), ContainerType.TOTAL_UNDER
        );
    }
}
