package com.savik.coeffs.hockey.other;


import com.savik.Coeff;
import com.savik.CoeffContainer;
import com.savik.ContainerType;

import java.util.Arrays;

public class CoeffPeriodOpposingTeamNotLooseAndTotalUnderBlock extends CoeffContainer {
    public CoeffPeriodOpposingTeamNotLooseAndTotalUnderBlock() {
        super(Arrays.asList(
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.UNDER_4_5
                ),
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.UNDER_5_5
                )
        ), ContainerType.OPPOSING_TEAM_NOT_LOOSE_AND_TOTAL_UNDER);
    }
}
