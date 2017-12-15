package com.savik.coeffs.hockey.stats;


import com.savik.CoeffContainer;
import com.savik.ContainerType;

import java.util.Arrays;

public class CoeffStatsBlock extends CoeffContainer {
    public CoeffStatsBlock() {
        super(Arrays.asList(
                new CoeffShotsOnTargetTotalOverBlock(),
                new CoeffTeamShotsOnTargetTotalOverBlock(),
                new CoeffOpposingTeamShotsOnTargetTotalOverBlock()
        ), ContainerType.STATS);
    }
}
