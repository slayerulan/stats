package com.savik.result_block.hockey.match.general.other;

import com.savik.ContainerType;
import com.savik.PeriodBetContainer;
import com.savik.bets.general.goals.PeriodFirstGoalTimeBefore;
import com.savik.hockey.model.HockeyMatch;


class GeneralFirstGoalBefore9Block extends PeriodBetContainer {

    public GeneralFirstGoalBefore9Block() {
        super(
                new PeriodFirstGoalTimeBefore(9), HockeyMatch.MATCH, ContainerType.FIRST_GOAL_BEFORE
        );
    }
}
