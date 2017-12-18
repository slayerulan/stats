package com.savik.coeffs.hockey.handicap;


import com.savik.CoeffContainer;
import com.savik.ContainerType;

import java.util.Arrays;

public class CoeffHandicapBlock extends CoeffContainer {
    public CoeffHandicapBlock() {
        super(Arrays.asList(
            new CoeffTeamHandicapBlock(),
            new CoeffOpposingTeamHandicapBlock()
        ), ContainerType.HANDICAP);
    }
}
