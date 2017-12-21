package com.savik.blocks.hockey.match.general.other;


import com.savik.ContainerType;
import com.savik.PossibleBetContainer;
import com.savik.bets.general.goals.PeriodLastGoalAfterPossibleBet;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;

class PeriodLastGoalAfterPossibleBetBlock extends PossibleBetContainer<HockeyMatch> {
    public PeriodLastGoalAfterPossibleBetBlock() {
        super(Arrays.asList(
                new PossibleBetContainer<>(
                        new PeriodLastGoalAfterPossibleBet<>(HockeyMatch.MATCH, 50),
                        ContainerType.OVER_50
                ),
                new PossibleBetContainer<>(
                        new PeriodLastGoalAfterPossibleBet<>(HockeyMatch.MATCH, 54),
                        ContainerType.OVER_54
                ),
                new PossibleBetContainer<>(
                        new PeriodLastGoalAfterPossibleBet<>(HockeyMatch.MATCH, 55),
                        ContainerType.OVER_55
                )
                ), ContainerType.LAST_GOAL_AFTER
        );
    }
}
