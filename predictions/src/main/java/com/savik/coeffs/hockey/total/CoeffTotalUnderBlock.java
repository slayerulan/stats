package com.savik.coeffs.hockey.total;


import com.savik.Coeff;
import com.savik.CoeffContainer;
import com.savik.ContainerType;

import java.util.Arrays;

public class CoeffTotalUnderBlock extends CoeffContainer {
    public CoeffTotalUnderBlock() {
        super(Arrays.asList(
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.UNDER_5_5
                ),
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.UNDER_6_5
                )
        ), ContainerType.TOTAL_UNDER);
    }
}
