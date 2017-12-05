package com.savik.result_block.hockey.match.general.other;

import com.savik.ContainerType;
import com.savik.GeneralBetContainer;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;

import static com.savik.ContainerType.FIRST_PERIOD_ANY_WINNER;
import static com.savik.ContainerType.SECOND_PERIOD_ANY_WINNER;
import static com.savik.ContainerType.THIRD_PERIOD_ANY_WINNER;


public class GeneralOtherBlock extends GeneralBetContainer {

    public GeneralOtherBlock() {
        super(Arrays.asList(
                new GeneralTotalOverAllPeriodsBlock(),
                new GeneralTotalUnderAllPeriodsBlock(),
                new GeneralAnyWinAndTotalOverBlock(),
                new GeneralAnyWinAndTotalUnderBlock(),
                new GeneralAnyWinAndDiffEqualsBlock(),
                new GeneralFirstGoalBeforeBlock(),
                new GeneralLastGoalAfterBlock(),
                new GeneralPeriodAnyWinnerBlock(HockeyMatch.FIRST_PERIOD, FIRST_PERIOD_ANY_WINNER),
                new GeneralPeriodAnyWinnerBlock(HockeyMatch.SECOND_PERIOD, SECOND_PERIOD_ANY_WINNER),
                new GeneralPeriodAnyWinnerBlock(HockeyMatch.THIRD_PERIOD, THIRD_PERIOD_ANY_WINNER)
        ), ContainerType.OTHER);
    }
}
