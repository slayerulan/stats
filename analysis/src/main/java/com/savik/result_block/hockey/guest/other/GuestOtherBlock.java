package com.savik.result_block.hockey.guest.other;

import com.savik.ContainerType;
import com.savik.GeneralBetContainer;

import java.util.Arrays;


public class GuestOtherBlock extends GeneralBetContainer {

    public GuestOtherBlock() {
        super(Arrays.asList(
                new GuestWinAndOverBlock(),
                new GuestWinAndUnderBlock()
        ), ContainerType.OTHER);
    }
}
