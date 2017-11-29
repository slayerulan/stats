package com.savik.result_block.hockey.home.total;

import com.savik.ContainerType;
import com.savik.GeneralBetContainer;

import java.util.Arrays;


public class HomeTotalBlock extends GeneralBetContainer {

    public HomeTotalBlock() {
        super(Arrays.asList(
                new HomeTotalOverBlock(),
                new HomeTotalUnderBlock()
        ), ContainerType.TOTAL);
    }
}
