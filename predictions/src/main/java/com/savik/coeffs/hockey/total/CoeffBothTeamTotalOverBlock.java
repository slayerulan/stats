package com.savik.coeffs.hockey.total;


import com.savik.Coeff;
import com.savik.CoeffContainer;
import com.savik.ContainerType;

import java.util.Arrays;

public class CoeffBothTeamTotalOverBlock extends CoeffContainer {
    public CoeffBothTeamTotalOverBlock() {
        super(Arrays.asList(
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.OVER_1_5
                ),
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.OVER_2_5
                )
        ), ContainerType.BOTH_TEAMS_TOTAL_OVER);
    }
}
