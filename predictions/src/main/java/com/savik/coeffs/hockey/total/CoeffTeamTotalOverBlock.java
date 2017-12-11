package com.savik.coeffs.hockey.total;


import com.savik.Coeff;
import com.savik.CoeffContainer;
import com.savik.ContainerType;

import java.util.Arrays;

public class CoeffTeamTotalOverBlock extends CoeffContainer {
    public CoeffTeamTotalOverBlock() {
        super(Arrays.asList(
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.OVER_2_5
                ),
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.OVER_3_5
                )
        ), ContainerType.TEAM_TOTAL_OVER);
    }
}
