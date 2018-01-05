package com.savik.coeffs.hockey.stats;


import com.savik.Coeff;
import com.savik.CoeffContainer;
import com.savik.ContainerType;

import java.util.Arrays;

public class CoeffTeamPenaltiesTimeTotalOverBlock extends CoeffContainer {
    public CoeffTeamPenaltiesTimeTotalOverBlock() {
        super(Arrays.asList(
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.OVER_6_5
                ),
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.OVER_7_5
                ),
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.OVER_8_5
                )
        ), ContainerType.TEAM_MINOR_PENALTIES_TIME_OVER);
    }
}
