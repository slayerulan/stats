package com.savik.coeffs.hockey.stats;


import com.savik.Coeff;
import com.savik.CoeffContainer;
import com.savik.ContainerType;

import java.util.Arrays;

public class CoeffTeamMinorPenaltiesTimeHandicapBlock extends CoeffContainer {
    public CoeffTeamMinorPenaltiesTimeHandicapBlock() {
        super(Arrays.asList(
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.PLUS_4_5
                ),
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.PLUS_2_5
                ),
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.MINUS_2_5
                )
        ), ContainerType.TEAM_MINOR_PENALTIES_TIME_HANDICAP);
    }
}
