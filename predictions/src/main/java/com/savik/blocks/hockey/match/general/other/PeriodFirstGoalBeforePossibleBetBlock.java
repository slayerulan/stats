package com.savik.blocks.hockey.match.general.other;


import com.savik.ContainerType;
import com.savik.PossibleBetContainer;
import com.savik.bets.general.goals.PeriodFirstGoalBeforePossibleBet;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;

class PeriodFirstGoalBeforePossibleBetBlock extends PossibleBetContainer<HockeyMatch> {
    public PeriodFirstGoalBeforePossibleBetBlock() {
        super(Arrays.asList(
                new PossibleBetContainer<>(
                        new PeriodFirstGoalBeforePossibleBet<>(HockeyMatch.MATCH, 9),
                        ContainerType.UNDER_9
                ),
                new PossibleBetContainer<>(
                        new PeriodFirstGoalBeforePossibleBet<>(HockeyMatch.MATCH, 10),
                        ContainerType.UNDER_10
                )
                ), ContainerType.FIRST_GOAL_BEFORE
        );
    }
}
