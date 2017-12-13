package com.savik.blocks.hockey.match.general.stats;


import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.PossibleBetContainer;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;

public class PossibleBetsStatsBlock extends PossibleBetContainer<HockeyMatch> {
    public PossibleBetsStatsBlock(MatchData homeMatchData, MatchData guestMatchData) {
        super(Arrays.asList(
                new ShotsOnTargetTotalOverPossibleBetBlock(),
                new PowerplayGoalsTotalOverPossibleBetBlock()
        ), ContainerType.STATS);
    }
}
