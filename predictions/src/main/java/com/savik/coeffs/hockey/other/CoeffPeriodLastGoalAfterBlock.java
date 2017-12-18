package com.savik.coeffs.hockey.other;


import com.savik.Coeff;
import com.savik.CoeffContainer;
import com.savik.ContainerType;

import java.util.Arrays;

public class CoeffPeriodLastGoalAfterBlock extends CoeffContainer {
    public CoeffPeriodLastGoalAfterBlock() {
        super(Arrays.asList(
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.OVER_54
                ),
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.OVER_55
                )
        ), ContainerType.LAST_GOAL_AFTER);
    }
}
