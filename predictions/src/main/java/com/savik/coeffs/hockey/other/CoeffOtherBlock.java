package com.savik.coeffs.hockey.other;


import com.savik.CoeffContainer;
import com.savik.ContainerType;

import java.util.Arrays;

public class CoeffOtherBlock extends CoeffContainer {
    public CoeffOtherBlock() {
        super(Arrays.asList(
            new CoeffPeriodAnyWinAndDiffEqualsBlock(),
           // new CoeffPeriodAnyWinAndTotalOverBlock(),
           // new CoeffPeriodAnyWinAndTotalUnderBlock(),

            new CoeffPeriodTeamWinAndTotalOverBlock(),
            new CoeffPeriodTeamWinAndTotalUnderBlock(),
            new CoeffPeriodTeamNotLooseAndTotalOverBlock(),
            new CoeffPeriodTeamNotLooseAndTotalUnderBlock(),

            new CoeffPeriodOpposingTeamWinAndTotalOverBlock(),
            new CoeffPeriodOpposingTeamWinAndTotalUnderBlock(),
            new CoeffPeriodOpposingTeamNotLooseAndTotalOverBlock(),
            new CoeffPeriodOpposingTeamNotLooseAndTotalUnderBlock()
        ), ContainerType.OTHER);
    }
}
