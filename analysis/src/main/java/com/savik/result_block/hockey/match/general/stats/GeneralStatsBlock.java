package com.savik.result_block.hockey.match.general.stats;

import com.savik.ContainerType;
import com.savik.GeneralBetContainer;
import com.savik.MatchData;

import java.util.Arrays;


public class GeneralStatsBlock extends GeneralBetContainer {

    public GeneralStatsBlock(MatchData matchData) {
        super(Arrays.asList(
                new GeneralShotsOnTargetTotalOverBlock(),
                new GeneralPenaltiesTimeTotalOverBlock(),
                new GeneralPowerplayGoalsTotalOverBlock(),
                new GeneralTeamShotsOnTargetTotalOverBlock(matchData),
                new GeneralOpposingTeamShotsOnTargetTotalOverBlock(matchData)
        ), ContainerType.STATS);
    }
}
