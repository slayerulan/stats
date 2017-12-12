package com.savik.coeffs.hockey.periods;


import com.savik.Coeff;
import com.savik.CoeffContainer;
import com.savik.ContainerType;

import java.util.Arrays;

public class CoeffPeriodsBlock extends CoeffContainer {
    public CoeffPeriodsBlock() {
        super(Arrays.asList(
                new CoeffContainer(
                        Arrays.asList(
                                new CoeffContainer(new Coeff(1.43), ContainerType.ANY_WIN),
                                new CoeffContainer(new Coeff(2.7), ContainerType.DRAW),
                                new CoeffContainer(new Coeff(1.4), ContainerType.TEAM_NOT_LOOSE),
                                new CoeffContainer(new Coeff(1.35), ContainerType.OPPOSING_TEAM_NOT_LOOSE),
                                new CoeffContainer(Arrays.asList(
                                        new CoeffContainer(
                                                new Coeff(1.22),
                                                ContainerType.OVER_0_5
                                        ),
                                        new CoeffContainer(
                                                new Coeff(1.96),
                                                ContainerType.OVER_1_5
                                        )
                                ), ContainerType.TOTAL_OVER),
                                new CoeffContainer(Arrays.asList(
                                        new CoeffContainer(
                                                new Coeff(1.82),
                                                ContainerType.UNDER_1_5
                                        ),
                                        new CoeffContainer(
                                                new Coeff(1.19),
                                                ContainerType.UNDER_2_5
                                        )
                                ), ContainerType.TOTAL_UNDER),
                                new CoeffContainer(Arrays.asList(
                                        new CoeffContainer(
                                                new Coeff(1.8, 2.0),
                                                ContainerType.OVER_0_5
                                        )
                                ), ContainerType.TEAM_TOTAL_OVER),

                                new CoeffContainer(Arrays.asList(
                                        new CoeffContainer(
                                                new Coeff(1.75, 2.08),
                                                ContainerType.OVER_0_5
                                        )
                                ), ContainerType.OPPOSING_TEAM_TOTAL_OVER),
                                new CoeffContainer(Arrays.asList(
                                        new CoeffContainer(
                                                new Coeff(3.04, 1.38),
                                                ContainerType.OVER_0_5
                                        )
                                ), ContainerType.BOTH_TEAMS_TOTAL_OVER)
                        ), ContainerType.FIRST_PERIOD
                ),
                new CoeffContainer(
                        Arrays.asList(
                                new CoeffContainer(new Coeff(1.36), ContainerType.ANY_WIN),
                                new CoeffContainer(new Coeff(2.91), ContainerType.DRAW),
                                new CoeffContainer(new Coeff(1.41), ContainerType.TEAM_NOT_LOOSE),
                                new CoeffContainer(new Coeff(1.4), ContainerType.OPPOSING_TEAM_NOT_LOOSE),
                                new CoeffContainer(Arrays.asList(
                                        new CoeffContainer(
                                                new Coeff(1.1),
                                                ContainerType.OVER_0_5
                                        ),
                                        new CoeffContainer(
                                                new Coeff(1.68),
                                                ContainerType.OVER_1_5
                                        )
                                ), ContainerType.TOTAL_OVER),
                                new CoeffContainer(Arrays.asList(
                                        new CoeffContainer(
                                                new Coeff(2.19),
                                                ContainerType.UNDER_1_5
                                        ),
                                        new CoeffContainer(
                                                new Coeff(1.39),
                                                ContainerType.UNDER_2_5
                                        )
                                ), ContainerType.TOTAL_UNDER),
                                new CoeffContainer(Arrays.asList(
                                        new CoeffContainer(
                                                new Coeff(1.57, 2.4),
                                                ContainerType.OVER_0_5
                                        )
                                ), ContainerType.TEAM_TOTAL_OVER),

                                new CoeffContainer(Arrays.asList(
                                        new CoeffContainer(
                                                new Coeff(1.53, 2.45),
                                                ContainerType.OVER_0_5
                                        )
                                ), ContainerType.OPPOSING_TEAM_TOTAL_OVER),
                                new CoeffContainer(Arrays.asList(
                                        new CoeffContainer(
                                                new Coeff(2.43, 1.56),
                                                ContainerType.OVER_0_5
                                        )
                                ), ContainerType.BOTH_TEAMS_TOTAL_OVER)
                        ), ContainerType.SECOND_PERIOD
                ),
                new CoeffContainer(
                        Arrays.asList(
                                new CoeffContainer(new Coeff(1.38), ContainerType.ANY_WIN),
                                new CoeffContainer(new Coeff(2.85), ContainerType.DRAW),
                                new CoeffContainer(new Coeff(1.42), ContainerType.TEAM_NOT_LOOSE),
                                new CoeffContainer(new Coeff(1.38), ContainerType.OPPOSING_TEAM_NOT_LOOSE),
                                new CoeffContainer(Arrays.asList(
                                        new CoeffContainer(
                                                new Coeff(1.16),
                                                ContainerType.OVER_0_5
                                        ),
                                        new CoeffContainer(
                                                new Coeff(1.74),
                                                ContainerType.OVER_1_5
                                        )
                                ), ContainerType.TOTAL_OVER),
                                new CoeffContainer(Arrays.asList(
                                        new CoeffContainer(
                                                new Coeff(2.09),
                                                ContainerType.UNDER_1_5
                                        ),
                                        new CoeffContainer(
                                                new Coeff(1.35),
                                                ContainerType.UNDER_2_5
                                        )
                                ), ContainerType.TOTAL_UNDER),
                                new CoeffContainer(Arrays.asList(
                                        new CoeffContainer(
                                                new Coeff(1.6, 2.3),
                                                ContainerType.OVER_0_5
                                        )
                                ), ContainerType.TEAM_TOTAL_OVER),

                                new CoeffContainer(Arrays.asList(
                                        new CoeffContainer(
                                                new Coeff(1.57, 2.38),
                                                ContainerType.OVER_0_5
                                        )
                                ), ContainerType.OPPOSING_TEAM_TOTAL_OVER),
                                new CoeffContainer(Arrays.asList(
                                        new CoeffContainer(
                                                new Coeff(2.53, 1.25),
                                                ContainerType.OVER_0_5
                                        )
                                ), ContainerType.BOTH_TEAMS_TOTAL_OVER)
                        ), ContainerType.THIRD_PERIOD
                )
        ), ContainerType.PERIODS);
    }
}
