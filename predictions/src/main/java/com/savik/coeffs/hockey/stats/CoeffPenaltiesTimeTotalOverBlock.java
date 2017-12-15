package com.savik.coeffs.hockey.stats;


import com.savik.Coeff;
import com.savik.CoeffContainer;
import com.savik.ContainerType;

import java.util.Arrays;

public class CoeffPenaltiesTimeTotalOverBlock extends CoeffContainer {
    public CoeffPenaltiesTimeTotalOverBlock() {
        super(Arrays.asList(
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.OVER_13_5
                ),
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.OVER_14_5
                ),
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.OVER_15_5
                )
        ), ContainerType.PENALTIES_TIME_OVER);
    }
}
