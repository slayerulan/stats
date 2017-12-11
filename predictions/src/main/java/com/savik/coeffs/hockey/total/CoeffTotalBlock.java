package com.savik.coeffs.hockey.total;


import com.savik.CoeffContainer;
import com.savik.ContainerType;

import java.util.Arrays;

public class CoeffTotalBlock extends CoeffContainer {
    public CoeffTotalBlock() {
        super(Arrays.asList(
                new CoeffTotalOverBlock(),
                new CoeffTotalUnderBlock(),
                new CoeffBothTeamTotalOverBlock(),
                new CoeffBothTeamTotalUnderBlock(),
                new CoeffTeamTotalOverBlock(),
                new CoeffTeamTotalUnderBlock(),
                new CoeffOpposingTeamTotalOverBlock(),
                new CoeffOpposingTeamTotalUnderBlock()
        ), ContainerType.TOTAL);
    }
}