package com.savik.coeffs.football.corners;


import com.savik.CoeffContainer;
import com.savik.ContainerType;

import java.util.Arrays;

public class CoeffCornersBlock extends CoeffContainer {
    public CoeffCornersBlock() {
        super(Arrays.asList(
                new CoeffCornersTotalOverBlock(),
                new CoeffCornersTotalUnderBlock(),
                new CoeffTeamCornersTotalOverBlock(),
                new CoeffOpposingTeamCornersTotalOverBlock(),
                new CoeffTeamCornersNotLooseBlock(),
                new CoeffOpposingTeamCornersNotLooseBlock(),
                new CoeffTeamCornersHandicapBlock(),
                new CoeffOpposingTeamCornersHandicapBlock()
        ), ContainerType.CORNERS);
    }
}
