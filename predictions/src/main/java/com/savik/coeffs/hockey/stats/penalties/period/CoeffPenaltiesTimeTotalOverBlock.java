package com.savik.coeffs.hockey.stats.penalties.period;


import com.savik.Coeff;
import com.savik.CoeffContainer;
import com.savik.ContainerType;

import java.util.Arrays;

public class CoeffPenaltiesTimeTotalOverBlock extends CoeffContainer {
    public CoeffPenaltiesTimeTotalOverBlock() {
        super(Arrays.asList(
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.OVER_2_5
                ),
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.OVER_4_5
                ),
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.OVER_6_5
                ),
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.OVER_12_5
                ),
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
                ),
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.OVER_16_5
                ),
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.OVER_18_5
                ),
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.OVER_20_5
                ),
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.OVER_22_5
                )
        ), ContainerType.MINOR_PENALTIES_TIME_OVER);
    }
}
