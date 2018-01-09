package com.savik.coeffs.hockey.other;


import com.savik.Coeff;
import com.savik.CoeffContainer;
import com.savik.ContainerType;

import java.util.Arrays;

public class CoeffTotalOverInAllPeriodsBlock extends CoeffContainer {
    public CoeffTotalOverInAllPeriodsBlock() {
        super(Arrays.asList(
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.OVER_0_5
                )
        ), ContainerType.TOTAL_OVER_ALL_PERIODS);
    }
}
