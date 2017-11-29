package com.savik.result_block.hockey.general;

import com.savik.ContainerType;
import com.savik.GeneralBetContainer;
import com.savik.result_block.hockey.general.other.GeneralOtherBlock;
import com.savik.result_block.hockey.general.total.GeneralTotalBlock;

import java.util.Arrays;

/**
 * @author Savushkin Yauheni
 * @since 22.05.2017
 */
public class GeneralBlock extends GeneralBetContainer {

    public GeneralBlock() {
        super(Arrays.asList(
                new GeneralOtherBlock(),
                new GeneralTotalBlock()
        ), ContainerType.GENERAL);
    }
}
