package com.savik.blocks.football.match.corners.match;


import com.savik.ContainerType;
import com.savik.PossibleBetContainer;
import com.savik.bets.football.corners.PeriodCornersTotalUnderPossibleBet;
import com.savik.football.model.FootballMatch;

import java.util.Arrays;

public class CornersTotalUnderPossibleBetBlock extends PossibleBetContainer<FootballMatch> {
    public CornersTotalUnderPossibleBetBlock() {
        super(Arrays.asList(
                new PossibleBetContainer<>(
                        new PeriodCornersTotalUnderPossibleBet(FootballMatch.MATCH, 6.5),
                        ContainerType.UNDER_6_5
                ),
                new PossibleBetContainer<>(
                        new PeriodCornersTotalUnderPossibleBet(FootballMatch.MATCH, 7.5),
                        ContainerType.UNDER_7_5
                ),
                new PossibleBetContainer<>(
                        new PeriodCornersTotalUnderPossibleBet(FootballMatch.MATCH, 8.5),
                        ContainerType.UNDER_8_5
                ),
                new PossibleBetContainer<>(
                        new PeriodCornersTotalUnderPossibleBet(FootballMatch.MATCH, 9.5),
                        ContainerType.UNDER_9_5
                ),
                new PossibleBetContainer<>(
                        new PeriodCornersTotalUnderPossibleBet(FootballMatch.MATCH, 10.5),
                        ContainerType.UNDER_10_5
                ),
                new PossibleBetContainer<>(
                        new PeriodCornersTotalUnderPossibleBet(FootballMatch.MATCH, 11.5),
                        ContainerType.UNDER_11_5
                ),
                new PossibleBetContainer<>(
                        new PeriodCornersTotalUnderPossibleBet(FootballMatch.MATCH, 12.5),
                        ContainerType.UNDER_12_5
                )
                ), ContainerType.TOTAL_UNDER
        );
    }
}
