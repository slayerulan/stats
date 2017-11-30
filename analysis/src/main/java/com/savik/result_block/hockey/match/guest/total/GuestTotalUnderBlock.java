package com.savik.result_block.hockey.match.guest.total;

import com.savik.ContainerType;
import com.savik.PeriodBetContainer;
import com.savik.blocks.general.total.under.PeriodGuestUnderSingleBlock;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;


class GuestTotalUnderBlock extends PeriodBetContainer {


    public GuestTotalUnderBlock() {
        super(
                Arrays.asList(
                        new PeriodGuestUnderSingleBlock(2.5),
                        new PeriodGuestUnderSingleBlock(3.5),
                        new PeriodGuestUnderSingleBlock(4.5),
                        new PeriodGuestUnderSingleBlock(5.5)
                ), HockeyMatch.MATCH, ContainerType.TOTAL_UNDER
        );
    }
}
