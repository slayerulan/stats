package com.savik.coeffs.hockey.stats.penalties.period;


import com.savik.CoeffContainer;
import com.savik.ContainerType;

import java.util.Arrays;

public class CoeffPeriodPenaltiesStatsBlock extends CoeffContainer {
    public CoeffPeriodPenaltiesStatsBlock(ContainerType containerType) {
        super(Arrays.asList(
                new CoeffPenaltiesTimeTotalOverBlock(),
                new CoeffTeamMinorPenaltiesTimeTotalOverBlock(),
                new CoeffOpposingTeamMinorPenaltiesTimeTotalOverBlock(),
                new CoeffTeamMinorPenaltiesTimeNotLooseBlock(),
                new CoeffOpposingTeamMinorPenaltiesTimeNotLooseBlock(),
                new CoeffTeamMinorPenaltiesTimeHandicapBlock(),
                new CoeffOpposingTeamMinorPenaltiesTimeHandicapBlock()
        ), containerType);
    }
}
