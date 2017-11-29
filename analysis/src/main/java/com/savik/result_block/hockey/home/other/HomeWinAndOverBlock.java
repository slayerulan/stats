package com.savik.result_block.hockey.home.other;

import com.savik.PeriodBetContainer;
import com.savik.bets.general.result.PeriodHomeWinner;
import com.savik.blocks.general.other.PeriodWinAndOverSingleBlock;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;

import static com.savik.ContainerType.HOME_WIN_AND_TOTAL_OVER;


class HomeWinAndOverBlock extends PeriodBetContainer {

    public HomeWinAndOverBlock() {
        super(
                Arrays.asList(
                        new PeriodWinAndOverSingleBlock<HockeyMatch>(3.5, new PeriodHomeWinner()),
                        new PeriodWinAndOverSingleBlock<HockeyMatch>(4.5, new PeriodHomeWinner())
                ), HockeyMatch.MATCH, HOME_WIN_AND_TOTAL_OVER
        );
    }
}
