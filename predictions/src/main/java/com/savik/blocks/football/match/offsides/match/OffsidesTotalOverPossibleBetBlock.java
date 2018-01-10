package com.savik.blocks.football.match.offsides.match;


import com.savik.ContainerType;
import com.savik.PossibleBetContainer;
import com.savik.bets.football.offsides.PeriodOffsidesTotalOverPossibleBet;
import com.savik.football.model.FootballMatch;

import java.util.Arrays;

public class OffsidesTotalOverPossibleBetBlock extends PossibleBetContainer<FootballMatch> {
    public OffsidesTotalOverPossibleBetBlock() {
        super(Arrays.asList(
                new PossibleBetContainer<>(
                        new PeriodOffsidesTotalOverPossibleBet(FootballMatch.MATCH, 2.5),
                        ContainerType.OVER_2_5
                ),
                new PossibleBetContainer<>(
                        new PeriodOffsidesTotalOverPossibleBet(FootballMatch.MATCH, 3.5),
                        ContainerType.OVER_3_5
                ),
                new PossibleBetContainer<>(
                        new PeriodOffsidesTotalOverPossibleBet(FootballMatch.MATCH, 4.5),
                        ContainerType.OVER_4_5
                ),
                new PossibleBetContainer<>(
                        new PeriodOffsidesTotalOverPossibleBet(FootballMatch.MATCH, 5.5),
                        ContainerType.OVER_5_5
                ),
                new PossibleBetContainer<>(
                        new PeriodOffsidesTotalOverPossibleBet(FootballMatch.MATCH, 6.5),
                        ContainerType.OVER_6_5
                ),
                new PossibleBetContainer<>(
                        new PeriodOffsidesTotalOverPossibleBet(FootballMatch.MATCH, 7.5),
                        ContainerType.OVER_7_5
                )
                ), ContainerType.TOTAL_OVER
        );
    }
}
