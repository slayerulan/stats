package com.savik.coeffs.hockey.other;


import com.savik.CoeffContainer;
import com.savik.ContainerType;

import java.util.Arrays;

public class CoeffOtherBlock extends CoeffContainer {
    public CoeffOtherBlock() {
        super(Arrays.asList(
                new CoeffTotalOverInAllPeriodsBlock(),
                new CoeffTotalUnderInAllPeriodsBlock(),


                new CoeffPeriodAnyWinAndTotalOverBlock(),
                new CoeffPeriodAnyWinAndTotalUnderBlock(),
                new CoeffPeriodAnyWinAndDiffEqualsBlock(),

                new CoeffPeriodFirstGoalBeforeBlock(),
                new CoeffPeriodLastGoalAfterBlock(),

                new CoeffPeriodTeamWinAndTotalOverBlock(),
                new CoeffPeriodTeamWinAndTotalUnderBlock(),
                new CoeffPeriodTeamNotLooseAndTotalOverBlock(),
                new CoeffPeriodTeamNotLooseAndTotalUnderBlock(),

                new CoeffPeriodOpposingTeamWinAndTotalOverBlock(),
                new CoeffPeriodOpposingTeamWinAndTotalUnderBlock(),
                new CoeffPeriodOpposingTeamNotLooseAndTotalOverBlock(),
                new CoeffPeriodOpposingTeamNotLooseAndTotalUnderBlock(),

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
