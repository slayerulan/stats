package com.savik.coeffs.hockey.other;


import com.savik.Coeff;
import com.savik.CoeffContainer;
import com.savik.ContainerType;

import java.util.Arrays;

public class CoeffTeamTotalOverInAllPeriodsBlock extends CoeffContainer {
    public CoeffTeamTotalOverInAllPeriodsBlock() {
        super(Arrays.asList(
                new CoeffContainer(
                        new Coeff(1.6),
                        ContainerType.OVER_0_5
                )
        ), ContainerType.TEAM_TOTAL_OVER_ALL_PERIODS);
    }
}
