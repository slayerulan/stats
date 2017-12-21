package com.savik.coeffs.hockey.other;


import com.savik.Coeff;
import com.savik.CoeffContainer;
import com.savik.ContainerType;

import java.util.Arrays;

public class CoeffAnyWinAndDiffEqualsBlock extends CoeffContainer {
    public CoeffAnyWinAndDiffEqualsBlock() {
        super(Arrays.asList(
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.DIFF_1
                ),
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.DIFF_2
                ),
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.DIFF_3_OR_MORE
                )
        ), ContainerType.ANY_WIN_AND_DIFFERENCE_EQUALS);
    }
}
