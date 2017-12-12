package com.savik.coeffs.hockey.other;


import com.savik.Coeff;
import com.savik.CoeffContainer;
import com.savik.ContainerType;

import java.util.Arrays;

public class CoeffTotalUnderInAllPeriodsBlock extends CoeffContainer {
    public CoeffTotalUnderInAllPeriodsBlock() {
        super(Arrays.asList(
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.UNDER_2_5
                ),
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.UNDER_3_5
                )
        ), ContainerType.TOTAL_UNDER_ALL_PERIODS);
    }
}
