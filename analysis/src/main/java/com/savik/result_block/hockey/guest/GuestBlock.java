package com.savik.result_block.hockey.guest;

import com.savik.ContainerType;
import com.savik.GeneralBetContainer;
import com.savik.result_block.hockey.guest.other.GuestOtherBlock;
import com.savik.result_block.hockey.guest.total.GuestTotalBlock;

import java.util.Arrays;


public class GuestBlock extends GeneralBetContainer {

    public GuestBlock() {
        super(
                Arrays.asList(
                        new GuestTotalBlock(),
                        new GuestOtherBlock()
                ), ContainerType.GUEST
        );
    }
}
