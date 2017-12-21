package com.savik.coeffs.hockey.other;


import com.savik.Coeff;
import com.savik.CoeffContainer;
import com.savik.ContainerType;

import java.util.Arrays;

public class CoeffAnyWinAndTotalUnderBlock extends CoeffContainer {
    public CoeffAnyWinAndTotalUnderBlock() {
        super(Arrays.asList(
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.UNDER_5_5
                )
        ), ContainerType.ANY_WIN_AND_TOTAL_UNDER);
    }
}
