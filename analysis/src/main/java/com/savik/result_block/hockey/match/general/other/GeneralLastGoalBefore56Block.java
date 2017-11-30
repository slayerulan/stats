package com.savik.result_block.hockey.match.general.other;

import com.savik.ContainerType;
import com.savik.PeriodBetContainer;
import com.savik.bets.general.goals.PeriodLastGoalTimeAfter;
import com.savik.hockey.model.HockeyMatch;


class GeneralLastGoalBefore56Block extends PeriodBetContainer {

    public GeneralLastGoalBefore56Block() {
        super(
                new PeriodLastGoalTimeAfter(55), HockeyMatch.MATCH, ContainerType.LAST_GOAL_AFTER
        );
    }
}
