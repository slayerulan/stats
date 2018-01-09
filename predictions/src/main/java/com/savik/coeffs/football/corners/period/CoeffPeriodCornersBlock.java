package com.savik.coeffs.football.corners.period;


import com.savik.CoeffContainer;
import com.savik.ContainerType;

import java.util.Arrays;

public class CoeffPeriodCornersBlock extends CoeffContainer {
    public CoeffPeriodCornersBlock(ContainerType containerType) {
        super(Arrays.asList(
                new CoeffCornersTotalOverBlock(),
                new CoeffCornersTotalUnderBlock(),
                new CoeffTeamCornersTotalOverBlock(),
                new CoeffOpposingTeamCornersTotalOverBlock(),
                new CoeffTeamCornersNotLooseBlock(),
                new CoeffOpposingTeamCornersNotLooseBlock(),
                new CoeffTeamCornersHandicapBlock(),
                new CoeffOpposingTeamCornersHandicapBlock()
        ), containerType);
    }
}
