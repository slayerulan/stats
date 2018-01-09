package com.savik.coeffs.football.corners.period;


import com.savik.Coeff;
import com.savik.CoeffContainer;
import com.savik.ContainerType;

import java.util.Arrays;

public class CoeffCornersTotalOverBlock extends CoeffContainer {
    public CoeffCornersTotalOverBlock() {
        super(Arrays.asList(
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.OVER_2_5
                ),
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.OVER_3_5
                ),
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.OVER_4_5
                ),
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.OVER_5_5
                ),
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.OVER_6_5
                ),
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.OVER_7_5
                ),
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.OVER_8_5
                ),
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.OVER_9_5
                ),
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.OVER_10_5
                ),
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.OVER_11_5
                ),
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.OVER_12_5
                )
        ), ContainerType.TOTAL_OVER);
    }
}
