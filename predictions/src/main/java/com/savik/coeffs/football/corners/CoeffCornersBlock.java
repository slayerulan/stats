package com.savik.coeffs.football.corners;


import com.savik.CoeffContainer;
import com.savik.ContainerType;
import com.savik.coeffs.football.corners.period.CoeffPeriodCornersBlock;

import java.util.Arrays;

public class CoeffCornersBlock extends CoeffContainer {
    public CoeffCornersBlock() {
        super(Arrays.asList(
                new CoeffPeriodCornersBlock(ContainerType.MATCH),
                new CoeffPeriodCornersBlock(ContainerType.FIRST_PERIOD),
                new CoeffPeriodCornersBlock(ContainerType.SECOND_PERIOD)
        ), ContainerType.CORNERS);
    }
}
