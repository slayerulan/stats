package com.savik.result_block.hockey.home;

import com.savik.ContainerType;
import com.savik.GeneralBetContainer;
import com.savik.result_block.hockey.home.other.HomeOtherBlock;
import com.savik.result_block.hockey.home.total.HomeTotalBlock;

import java.util.Arrays;


public class HomeBlock extends GeneralBetContainer {

    public HomeBlock() {
        super(
                Arrays.asList(
                        new HomeTotalBlock(),
                        new HomeOtherBlock()
                ), ContainerType.HOME
        );
    }
}
