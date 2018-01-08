package com.savik.coeffs.football.cards;


import com.savik.Coeff;
import com.savik.CoeffContainer;
import com.savik.ContainerType;

import java.util.Arrays;

public class CoeffYellowCardsWDTotalUnderBlock extends CoeffContainer {
    public CoeffYellowCardsWDTotalUnderBlock() {
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
                )
        ), ContainerType.TOTAL_UNDER);
    }
}
