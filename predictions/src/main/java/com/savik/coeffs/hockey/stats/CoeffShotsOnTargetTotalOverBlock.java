package com.savik.coeffs.hockey.stats;


import com.savik.Coeff;
import com.savik.CoeffContainer;
import com.savik.ContainerType;

import java.util.Arrays;

public class CoeffShotsOnTargetTotalOverBlock extends CoeffContainer {
    public CoeffShotsOnTargetTotalOverBlock() {
        super(Arrays.asList(
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.OVER_57_5
                ),
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.OVER_58_5
                ),
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.OVER_59_5
                ),
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.OVER_60_5
                ),
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.OVER_61_5
                ),
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.OVER_62_5
                ),
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.OVER_63_5
                )
        ), ContainerType.SHOTS_ON_TARGET_OVER);
    }
}
