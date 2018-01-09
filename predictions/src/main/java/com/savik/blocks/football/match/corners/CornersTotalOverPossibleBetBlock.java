package com.savik.blocks.football.match.corners;


import com.savik.ContainerType;
import com.savik.PossibleBetContainer;
import com.savik.bets.football.corners.PeriodCornersTotalOverPossibleBet;
import com.savik.football.model.FootballMatch;

import java.util.Arrays;

public class CornersTotalOverPossibleBetBlock extends PossibleBetContainer<FootballMatch> {
    public CornersTotalOverPossibleBetBlock() {
        super(Arrays.asList(
                new PossibleBetContainer<>(
                        new PeriodCornersTotalOverPossibleBet(FootballMatch.MATCH, 6.5),
                        ContainerType.OVER_6_5
                ),
                new PossibleBetContainer<>(
                        new PeriodCornersTotalOverPossibleBet(FootballMatch.MATCH, 7.5),
                        ContainerType.OVER_7_5
                ),
                new PossibleBetContainer<>(
                        new PeriodCornersTotalOverPossibleBet(FootballMatch.MATCH, 8.5),
                        ContainerType.OVER_8_5
                ),
                new PossibleBetContainer<>(
                        new PeriodCornersTotalOverPossibleBet(FootballMatch.MATCH, 9.5),
                        ContainerType.OVER_9_5
                ),
                new PossibleBetContainer<>(
                        new PeriodCornersTotalOverPossibleBet(FootballMatch.MATCH, 10.5),
                        ContainerType.OVER_10_5
                ),
                new PossibleBetContainer<>(
                        new PeriodCornersTotalOverPossibleBet(FootballMatch.MATCH, 11.5),
                        ContainerType.OVER_11_5
                ),
                new PossibleBetContainer<>(
                        new PeriodCornersTotalOverPossibleBet(FootballMatch.MATCH, 12.5),
                        ContainerType.OVER_12_5
                )
                ), ContainerType.TOTAL_OVER
        );
    }
}
