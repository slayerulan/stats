package com.savik.result_block.hockey.match.guest.other;

import com.savik.PeriodBetContainer;
import com.savik.bets.general.result.PeriodGuestWinner;
import com.savik.blocks.general.other.PeriodWinAndOverSingleBlock;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;

import static com.savik.ContainerType.WIN_AND_TOTAL_OVER;


class GuestWinAndOverBlock extends PeriodBetContainer {

    public GuestWinAndOverBlock() {
        super(
                Arrays.asList(
                        new PeriodWinAndOverSingleBlock<HockeyMatch>(3.5, new PeriodGuestWinner()),
                        new PeriodWinAndOverSingleBlock<HockeyMatch>(4.5, new PeriodGuestWinner())
                ), HockeyMatch.MATCH, WIN_AND_TOTAL_OVER
        );
    }
}
