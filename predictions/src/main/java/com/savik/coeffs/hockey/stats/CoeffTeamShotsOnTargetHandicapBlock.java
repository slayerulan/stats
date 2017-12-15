package com.savik.coeffs.hockey.stats;


import com.savik.Coeff;
import com.savik.CoeffContainer;
import com.savik.ContainerType;

import java.util.Arrays;

public class CoeffTeamShotsOnTargetHandicapBlock extends CoeffContainer {
    public CoeffTeamShotsOnTargetHandicapBlock() {
        super(Arrays.asList(
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.MINUS_3_5
                ),
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.MINUS_2_5
                ),
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.MINUS_1_5
                ),
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.PLUS_1_5
                ),
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.PLUS_2_5
                ),
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.PLUS_3_5
                )
        ), ContainerType.TEAM_SHOTS_ON_TARGET_HANDICAP);
    }
}
