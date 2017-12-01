package com.savik.result_block.hockey.match.general.other;

import com.savik.PeriodBetContainer;
import com.savik.bets.general.result.PeriodAnyWinner;
import com.savik.blocks.general.other.PeriodWinAndOverSingleBlock;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;

import static com.savik.ContainerType.ANY_WIN_AND_TOTAL_OVER;


class GeneralAnyWinAndTotalOverBlock extends PeriodBetContainer {

    public GeneralAnyWinAndTotalOverBlock() {
        super(
                Arrays.asList(
                        new PeriodWinAndOverSingleBlock<HockeyMatch>(4.5, new PeriodAnyWinner()),
                        new PeriodWinAndOverSingleBlock<HockeyMatch>(5.5, new PeriodAnyWinner())
                ), HockeyMatch.MATCH, ANY_WIN_AND_TOTAL_OVER
        );
    }
}
