package com.savik.coeffs.hockey.other;


import com.savik.Coeff;
import com.savik.CoeffContainer;
import com.savik.ContainerType;

import java.util.Arrays;

public class CoeffTeamWinAndTotalOverBlock extends CoeffContainer {
    public CoeffTeamWinAndTotalOverBlock() {
        super(Arrays.asList(
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.OVER_4_5
                ),
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.OVER_5_5
                ),
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.OVER_6_5
                )
        ), ContainerType.TEAM_WIN_AND_TOTAL_OVER);
    }
}
