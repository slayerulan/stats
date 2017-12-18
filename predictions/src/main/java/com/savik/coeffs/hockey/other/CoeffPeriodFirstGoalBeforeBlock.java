package com.savik.coeffs.hockey.other;


import com.savik.Coeff;
import com.savik.CoeffContainer;
import com.savik.ContainerType;

import java.util.Arrays;

public class CoeffPeriodFirstGoalBeforeBlock extends CoeffContainer {
    public CoeffPeriodFirstGoalBeforeBlock() {
        super(Arrays.asList(
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.UNDER_9
                ),
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.UNDER_10
                )
        ), ContainerType.FIRST_GOAL_BEFORE);
    }
}
