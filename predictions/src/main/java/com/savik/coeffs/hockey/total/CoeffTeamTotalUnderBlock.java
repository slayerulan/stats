package com.savik.coeffs.hockey.total;


import com.savik.Coeff;
import com.savik.CoeffContainer;
import com.savik.ContainerType;

import java.util.Arrays;

public class CoeffTeamTotalUnderBlock extends CoeffContainer {
    public CoeffTeamTotalUnderBlock() {
        super(Arrays.asList(
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.UNDER_1_5
                ),
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.UNDER_2_5
                ),
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.UNDER_3_5
                )
        ), ContainerType.TEAM_TOTAL_UNDER);
    }
}
