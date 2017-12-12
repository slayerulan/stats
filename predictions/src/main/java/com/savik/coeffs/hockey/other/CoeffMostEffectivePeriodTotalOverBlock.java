package com.savik.coeffs.hockey.other;


import com.savik.Coeff;
import com.savik.CoeffContainer;
import com.savik.ContainerType;

import java.util.Arrays;

public class CoeffMostEffectivePeriodTotalOverBlock extends CoeffContainer {
    public CoeffMostEffectivePeriodTotalOverBlock() {
        super(Arrays.asList(
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.OVER_2_5
                ),
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.OVER_3_5
                )
        ), ContainerType.MOST_EFFECTIVE_PERIOD_TOTAL_OVER);
    }
}
