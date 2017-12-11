package com.savik.coeffs.hockey.total;


import com.savik.Coeff;
import com.savik.CoeffContainer;
import com.savik.ContainerType;

import java.util.Arrays;

public class CoeffBothTeamTotalUnderBlock extends CoeffContainer {
    public CoeffBothTeamTotalUnderBlock() {
        super(Arrays.asList(
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.UNDER_2_5
                ),
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.UNDER_3_5
                )
        ), ContainerType.BOTH_TEAMS_TOTAL_UNDER);
    }
}
