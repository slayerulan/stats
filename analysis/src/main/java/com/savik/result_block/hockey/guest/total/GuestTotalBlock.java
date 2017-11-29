package com.savik.result_block.hockey.guest.total;

import com.savik.ContainerType;
import com.savik.GeneralBetContainer;

import java.util.Arrays;


public class GuestTotalBlock extends GeneralBetContainer {

    public GuestTotalBlock() {
        super(Arrays.asList(
                new GuestTotalOverBlock(),
                new GuestTotalUnderBlock()
        ), ContainerType.TOTAL);
    }
}
