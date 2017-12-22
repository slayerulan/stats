package com.savik.coeffs.hockey.other;


import com.savik.Coeff;
import com.savik.CoeffContainer;
import com.savik.ContainerType;

import java.util.Arrays;

public class CoeffTeamNotLooseAndTotalUnderBlock extends CoeffContainer {
    public CoeffTeamNotLooseAndTotalUnderBlock() {
        super(Arrays.asList(
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.UNDER_4_5
                ),
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.UNDER_5_5
                ),
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.UNDER_6_5
                )
        ), ContainerType.TEAM_NOT_LOOSE_AND_TOTAL_UNDER);
    }
}
