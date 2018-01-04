package com.savik.coeffs.hockey.periods;


import com.savik.Coeff;
import com.savik.CoeffContainer;
import com.savik.ContainerType;

import java.util.Arrays;

public class CoeffPeriodBlock extends CoeffContainer {
    public CoeffPeriodBlock(ContainerType containerType) {
        super(Arrays.asList(
                new CoeffContainer(new Coeff(), ContainerType.ANY_WIN),
                new CoeffContainer(new Coeff(), ContainerType.DRAW),
                new CoeffContainer(new Coeff(), ContainerType.TEAM_NOT_LOOSE),
                new CoeffContainer(new Coeff(), ContainerType.OPPOSING_TEAM_NOT_LOOSE),
                new CoeffContainer(Arrays.asList(
                        new CoeffContainer(
                                new Coeff(),
                                ContainerType.BETWEEN_1_7
                        ),
                        new CoeffContainer(
                                new Coeff(),
                                ContainerType.BETWEEN_8_15
                        ),
                        new CoeffContainer(
                                new Coeff(),
                                ContainerType.BETWEEN_16_20
                        )
                ), ContainerType.GOAL_BETWEEN),
                new CoeffContainer(Arrays.asList(
                        new CoeffContainer(
                                new Coeff(),
                                ContainerType.OVER_0_5
                        ),
                        new CoeffContainer(
                                new Coeff(),
                                ContainerType.OVER_1_5
                        )
                ), ContainerType.TOTAL_OVER),
                new CoeffContainer(Arrays.asList(
                        new CoeffContainer(
                                new Coeff(),
                                ContainerType.UNDER_1_5
                        ),
                        new CoeffContainer(
                                new Coeff(),
                                ContainerType.UNDER_2_5
                        )
                ), ContainerType.TOTAL_UNDER),
                new CoeffContainer(Arrays.asList(
                        new CoeffContainer(
                                new Coeff(),
                                ContainerType.OVER_0_5
                        ),
                        new CoeffContainer(
                                new Coeff(),
                                ContainerType.OVER_1_5
                        )
                ), ContainerType.TEAM_TOTAL_OVER),

                new CoeffContainer(Arrays.asList(
                        new CoeffContainer(
                                new Coeff(),
                                ContainerType.OVER_0_5
                        ),
                        new CoeffContainer(
                                new Coeff(),
                                ContainerType.OVER_1_5
                        )
                ), ContainerType.OPPOSING_TEAM_TOTAL_OVER),
                new CoeffContainer(Arrays.asList(
                        new CoeffContainer(
                                new Coeff(),
                                ContainerType.OVER_0_5
                        )
                ), ContainerType.BOTH_TEAMS_TOTAL_OVER)
        ), containerType);
    }
}