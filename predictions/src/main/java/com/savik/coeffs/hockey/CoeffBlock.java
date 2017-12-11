package com.savik.coeffs.hockey;


import com.savik.CoeffContainer;
import com.savik.ContainerType;
import com.savik.coeffs.hockey.total.CoeffTotalBlock;

import java.util.Arrays;

public class CoeffBlock extends CoeffContainer {
    public CoeffBlock() {
        super(Arrays.asList(
                new CoeffTotalBlock()
        ), ContainerType.ROOT);
    }
}
