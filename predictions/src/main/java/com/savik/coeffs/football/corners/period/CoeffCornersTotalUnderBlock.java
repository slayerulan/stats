package com.savik.coeffs.football.corners.period;


import com.savik.Coeff;
import com.savik.CoeffContainer;
import com.savik.ContainerType;

import java.util.Arrays;

public class CoeffCornersTotalUnderBlock extends CoeffContainer {
    public CoeffCornersTotalUnderBlock() {
        super(Arrays.asList(
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.UNDER_2_5
                ),
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.UNDER_3_5
                ),
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.UNDER_4_5
                ),
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.UNDER_5_5
                ),
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.UNDER_6_5
                ),
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.UNDER_7_5
                ),
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.UNDER_8_5
                ),
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.UNDER_9_5
                ),
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.UNDER_10_5
                ),
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.UNDER_11_5
                ),
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.UNDER_12_5
                )
        ), ContainerType.TOTAL_UNDER);
    }
}