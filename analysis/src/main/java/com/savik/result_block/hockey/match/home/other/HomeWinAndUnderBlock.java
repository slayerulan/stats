package com.savik.result_block.hockey.match.home.other;

import com.savik.PeriodBetContainer;
import com.savik.bets.general.result.PeriodHomeWinner;
import com.savik.blocks.general.other.PeriodWinAndUnderSingleBlock;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;

import static com.savik.ContainerType.WIN_AND_TOTAL_UNDER;


class HomeWinAndUnderBlock extends PeriodBetContainer {

    public HomeWinAndUnderBlock() {
        super(
                Arrays.asList(
                        new PeriodWinAndUnderSingleBlock<HockeyMatch>(4.5, new PeriodHomeWinner())
                ), HockeyMatch.MATCH, WIN_AND_TOTAL_UNDER
        );
    }
}
