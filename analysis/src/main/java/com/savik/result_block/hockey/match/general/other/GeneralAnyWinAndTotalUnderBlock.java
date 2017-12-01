package com.savik.result_block.hockey.match.general.other;

import com.savik.PeriodBetContainer;
import com.savik.bets.general.result.PeriodAnyWinner;
import com.savik.blocks.general.other.PeriodWinAndUnderSingleBlock;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;

import static com.savik.ContainerType.ANY_WIN_AND_DIFFERENCE_EQUALS;


class GeneralAnyWinAndTotalUnderBlock extends PeriodBetContainer {

    public GeneralAnyWinAndTotalUnderBlock() {
        super(
                Arrays.asList(
                        new PeriodWinAndUnderSingleBlock<HockeyMatch>(4.5, new PeriodAnyWinner()),
                        new PeriodWinAndUnderSingleBlock<HockeyMatch>(5.5, new PeriodAnyWinner())
                ), HockeyMatch.MATCH, ANY_WIN_AND_DIFFERENCE_EQUALS
        );
    }
}
