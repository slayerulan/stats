package com.savik.coeffs.hockey.other;


import com.savik.Coeff;
import com.savik.CoeffContainer;
import com.savik.ContainerType;

import java.util.Arrays;

public class CoeffDrawAtLeastNPeriodsBlock extends CoeffContainer {
    public CoeffDrawAtLeastNPeriodsBlock() {
        super(Arrays.asList(
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.NUMBER_1
                ),
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.NUMBER_2
                )
        ), ContainerType.DRAW_AT_LEAST_N_PERIODS);
    }
}
