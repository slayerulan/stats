package com.savik.coeffs.hockey.periods;


import com.savik.CoeffContainer;
import com.savik.ContainerType;

import java.util.Arrays;

public class CoeffPeriodsBlock extends CoeffContainer {
    public CoeffPeriodsBlock() {
        super(Arrays.asList(
                new CoeffPeriodBlock(ContainerType.FIRST_PERIOD),
                new CoeffPeriodBlock(ContainerType.SECOND_PERIOD),
                new CoeffPeriodBlock(ContainerType.THIRD_PERIOD)
        ), ContainerType.PERIODS);
    }
}
