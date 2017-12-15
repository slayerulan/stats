package com.savik.coeffs.hockey.stats;


import com.savik.Coeff;
import com.savik.CoeffContainer;
import com.savik.ContainerType;

import java.util.Arrays;

public class CoeffTeamShotsOnTargetTotalOverBlock extends CoeffContainer {
    public CoeffTeamShotsOnTargetTotalOverBlock() {
        super(Arrays.asList(
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.OVER_28_5
                ),
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.OVER_30_5
                ),
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.OVER_32_5
                )
        ), ContainerType.TEAM_SHOTS_ON_TARGET_OVER);
    }
}
