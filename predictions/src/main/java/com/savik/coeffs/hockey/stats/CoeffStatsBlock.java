package com.savik.coeffs.hockey.stats;


import com.savik.CoeffContainer;
import com.savik.ContainerType;
import com.savik.coeffs.hockey.stats.penalties.CoeffPenaltiesStatsBlock;

import java.util.Arrays;

public class CoeffStatsBlock extends CoeffContainer {
    public CoeffStatsBlock() {
        super(Arrays.asList(
                new CoeffShotsOnTargetTotalOverBlock(),
                new CoeffTeamShotsOnTargetTotalOverBlock(),
                new CoeffOpposingTeamShotsOnTargetTotalOverBlock(),
                new CoeffTeamShotsOnTargetHandicapBlock(),
                new CoeffOpposingTeamShotsOnTargetHandicapBlock(),
                new CoeffTeamShotsOnTargetWinBlock(),
                new CoeffOpposingTeamShotsOnTargetWinBlock(),
                new CoeffPenaltiesStatsBlock(),
                new CoeffPowerplayGoalsTotalOverBlock()
        ), ContainerType.STATS);
    }
}
