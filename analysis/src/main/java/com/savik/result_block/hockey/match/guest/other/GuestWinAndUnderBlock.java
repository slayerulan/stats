package com.savik.result_block.hockey.match.guest.other;

import com.savik.PeriodBetContainer;
import com.savik.bets.general.result.PeriodGuestWinner;
import com.savik.blocks.general.other.PeriodWinAndUnderSingleBlock;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;

import static com.savik.ContainerType.WIN_AND_TOTAL_UNDER;


class GuestWinAndUnderBlock extends PeriodBetContainer {

    public GuestWinAndUnderBlock() {
        super(
                Arrays.asList(
                        new PeriodWinAndUnderSingleBlock<HockeyMatch>(4.5, new PeriodGuestWinner())
                ), HockeyMatch.MATCH, WIN_AND_TOTAL_UNDER
        );
    }
}
