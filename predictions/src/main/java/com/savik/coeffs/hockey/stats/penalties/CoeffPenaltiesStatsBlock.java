package com.savik.coeffs.hockey.stats.penalties;


import com.savik.CoeffContainer;
import com.savik.ContainerType;
import com.savik.coeffs.hockey.stats.penalties.period.*;

import java.util.Arrays;

public class CoeffPenaltiesStatsBlock extends CoeffContainer {
    public CoeffPenaltiesStatsBlock() {
        super(Arrays.asList(
                new CoeffPeriodPenaltiesStatsBlock(ContainerType.MATCH),
                new CoeffPeriodPenaltiesStatsBlock(ContainerType.FIRST_PERIOD)
        ), ContainerType.PENALTIES);
    }
}
