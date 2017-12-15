package com.savik.blocks.hockey.match.general.stats;


import com.savik.ContainerType;
import com.savik.PossibleBetContainer;
import com.savik.bets.hockey.stats.PowerplayGoalsTotalOverPossibleBet;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;

public class PowerplayGoalsTotalOverPossibleBetBlock extends PossibleBetContainer<HockeyMatch> {
    public PowerplayGoalsTotalOverPossibleBetBlock() {
        super(Arrays.asList(
                new PossibleBetContainer<>(
                        new PowerplayGoalsTotalOverPossibleBet(HockeyMatch.MATCH, 1.5),
                        ContainerType.OVER_1_5
                )
                ), ContainerType.POWERPLAY_GOALS_OVER
        );
    }
}
