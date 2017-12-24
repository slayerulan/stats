package com.savik.coeffs.hockey.other;


import com.savik.Coeff;
import com.savik.CoeffContainer;
import com.savik.ContainerType;

import java.util.Arrays;

public class CoeffPeriodXMoreEffectiveThanYBlock extends CoeffContainer {
    public CoeffPeriodXMoreEffectiveThanYBlock() {
        super(Arrays.asList(
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.P2_MORE_P1
                ),
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.P3_MORE_P2
                ),
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.P3_MORE_P1
                )
        ), ContainerType.PERIOD_X_MORE_EFFECTIVE_THAN_Y);
    }
}
