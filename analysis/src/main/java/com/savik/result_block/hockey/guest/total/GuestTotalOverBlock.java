package com.savik.result_block.hockey.guest.total;

import com.savik.ContainerType;
import com.savik.PeriodBetContainer;
import com.savik.blocks.general.total.over.PeriodGuestOverSingleBlock;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;


class GuestTotalOverBlock extends PeriodBetContainer {


    public GuestTotalOverBlock() {
        super(
                Arrays.asList(
                        new PeriodGuestOverSingleBlock(2.5),
                        new PeriodGuestOverSingleBlock(3.5),
                        new PeriodGuestOverSingleBlock(4.5),
                        new PeriodGuestOverSingleBlock(5.5)
                ), HockeyMatch.MATCH, ContainerType.TOTAL_OVER
        );
    }
}
