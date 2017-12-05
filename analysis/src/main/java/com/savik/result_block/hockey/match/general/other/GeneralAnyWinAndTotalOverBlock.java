package com.savik.result_block.hockey.match.general.other;

import com.savik.PeriodBetContainer;
import com.savik.bets.general.result.PeriodAnyWinner;
import com.savik.blocks.general.other.PeriodWinAndOverSingleBlock;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;

import static com.savik.ContainerType.ANY_WIN_AND_TOTAL_OVER;
import static com.savik.ContainerType.OVER_4_5;
import static com.savik.ContainerType.OVER_5_5;


class GeneralAnyWinAndTotalOverBlock extends PeriodBetContainer {

    public GeneralAnyWinAndTotalOverBlock() {
        super(
                Arrays.asList(
                        new PeriodWinAndOverSingleBlock<HockeyMatch>(4.5, new PeriodAnyWinner(), OVER_4_5),
                        new PeriodWinAndOverSingleBlock<HockeyMatch>(5.5, new PeriodAnyWinner(), OVER_5_5)
                ), HockeyMatch.MATCH, ANY_WIN_AND_TOTAL_OVER
        );
    }
}
