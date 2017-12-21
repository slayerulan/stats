package com.savik.coeffs.hockey.other;


import com.savik.CoeffContainer;
import com.savik.ContainerType;

import java.util.Arrays;

public class CoeffOtherBlock extends CoeffContainer {
    public CoeffOtherBlock() {
        super(Arrays.asList(
                new CoeffTotalOverInAllPeriodsBlock(),
                new CoeffTotalUnderInAllPeriodsBlock(),


                new CoeffAnyWinAndTotalOverBlock(),
                new CoeffAnyWinAndTotalUnderBlock(),
                new CoeffAnyWinAndDiffEqualsBlock(),

                new CoeffPeriodFirstGoalBeforeBlock(),
                new CoeffPeriodLastGoalAfterBlock(),

                new CoeffTeamWinAndTotalOverBlock(),
                new CoeffTeamWinAndTotalUnderBlock(),
                new CoeffTeamNotLooseAndTotalOverBlock(),
                new CoeffTeamNotLooseAndTotalUnderBlock(),

                new CoeffOpposingTeamWinAndTotalOverBlock(),
                new CoeffOpposingTeamWinAndTotalUnderBlock(),
                new CoeffOpposingTeamNotLooseAndTotalOverBlock(),
                new CoeffOpposingTeamNotLooseAndTotalUnderBlock(),

                new CoeffTeamTotalOverInAllPeriodsBlock(),
                new CoeffOpposingTeamTotalOverInAllPeriodsBlock(),

                new CoeffTeamWinAtLeastNPeriodsBlock(),
                new CoeffOpposingTeamWinAtLeastNPeriodsBlock(),
                new CoeffDrawAtLeastNPeriodsBlock(),

                new CoeffMostEffectivePeriodTotalOverBlock(),
                new CoeffTeamFirstScoredAndWinBlock(),
                new CoeffOpposingTeamFirstScoredAndWinBlock(),
                new CoeffAnyComebackMatchBlock()
        ), ContainerType.OTHER);
    }
}
