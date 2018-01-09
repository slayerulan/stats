package com.savik.coeffs.hockey.stats.penalties.period;


import com.savik.Coeff;
import com.savik.CoeffContainer;
import com.savik.ContainerType;

import java.util.Arrays;

public class CoeffOpposingTeamMinorPenaltiesTimeHandicapBlock extends CoeffContainer {
    public CoeffOpposingTeamMinorPenaltiesTimeHandicapBlock() {
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
        ), ContainerType.OPPOSING_TEAM_MINOR_PENALTIES_TIME_HANDICAP);
    }
}
