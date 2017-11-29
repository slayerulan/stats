package com.savik.result_block.hockey.general.total;

import com.savik.ContainerType;
import com.savik.GeneralBetContainer;

import java.util.Arrays;


public class GeneralTotalBlock extends GeneralBetContainer {

    public GeneralTotalBlock() {
        super(Arrays.asList(
                new GeneralTotalOverBlock(),
                new GeneralTotalUnderBlock()
        ), ContainerType.TOTAL);
    }
}
