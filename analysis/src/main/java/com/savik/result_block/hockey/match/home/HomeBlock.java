package com.savik.result_block.hockey.match.home;

import com.savik.ContainerType;
import com.savik.GeneralBetContainer;
import com.savik.result_block.hockey.match.home.other.HomeOtherBlock;
import com.savik.result_block.hockey.match.home.total.HomeTotalBlock;

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
