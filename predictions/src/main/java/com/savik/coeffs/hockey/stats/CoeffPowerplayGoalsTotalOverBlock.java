package com.savik.coeffs.hockey.stats;


import com.savik.Coeff;
import com.savik.CoeffContainer;
import com.savik.ContainerType;

import java.util.Arrays;

public class CoeffPowerplayGoalsTotalOverBlock extends CoeffContainer {
    public CoeffPowerplayGoalsTotalOverBlock() {
        super(Arrays.asList(
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.OVER_1_5
                )
        ), ContainerType.POWERPLAY_GOALS_OVER);
    }
}
