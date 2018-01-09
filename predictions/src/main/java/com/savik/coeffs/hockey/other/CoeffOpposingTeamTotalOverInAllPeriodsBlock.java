package com.savik.coeffs.hockey.other;


import com.savik.Coeff;
import com.savik.CoeffContainer;
import com.savik.ContainerType;

import java.util.Arrays;

public class CoeffOpposingTeamTotalOverInAllPeriodsBlock extends CoeffContainer {
    public CoeffOpposingTeamTotalOverInAllPeriodsBlock() {
        super(Arrays.asList(
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.OVER_0_5
                )
        ), ContainerType.OPPOSING_TEAM_TOTAL_OVER_ALL_PERIODS);
    }
}
