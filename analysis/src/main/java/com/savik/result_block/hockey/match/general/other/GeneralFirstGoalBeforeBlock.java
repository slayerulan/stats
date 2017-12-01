package com.savik.result_block.hockey.match.general.other;

import com.savik.ContainerType;
import com.savik.PeriodBetContainer;
import com.savik.bets.general.goals.PeriodFirstGoalTimeBefore;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;


class GeneralFirstGoalBeforeBlock extends PeriodBetContainer {

    public GeneralFirstGoalBeforeBlock() {
        super(
                Arrays.asList(
                        new PeriodFirstGoalTimeBefore(9),
                        new PeriodFirstGoalTimeBefore(10)
                ), HockeyMatch.MATCH, ContainerType.FIRST_GOAL_BEFORE
        );
    }
}
