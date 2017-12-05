package com.savik.result_block.hockey.match.general.other;

import com.savik.PeriodBetContainer;
import com.savik.bets.general.result.PeriodAnyWinner;
import com.savik.blocks.general.other.PeriodWinAndUnderSingleBlock;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;

import static com.savik.ContainerType.ANY_WIN_AND_TOTAL_UNDER;
import static com.savik.ContainerType.UNDER_4_5;
import static com.savik.ContainerType.UNDER_5_5;


class GeneralAnyWinAndTotalUnderBlock extends PeriodBetContainer {

    public GeneralAnyWinAndTotalUnderBlock() {
        super(
                Arrays.asList(
                        new PeriodWinAndUnderSingleBlock<HockeyMatch>(4.5, new PeriodAnyWinner(), UNDER_4_5),
                        new PeriodWinAndUnderSingleBlock<HockeyMatch>(5.5, new PeriodAnyWinner(), UNDER_5_5)
                ), HockeyMatch.MATCH, ANY_WIN_AND_TOTAL_UNDER
        );
    }
}
