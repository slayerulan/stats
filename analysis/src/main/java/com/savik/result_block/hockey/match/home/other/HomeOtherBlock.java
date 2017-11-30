package com.savik.result_block.hockey.match.home.other;

import com.savik.ContainerType;
import com.savik.GeneralBetContainer;

import java.util.Arrays;


public class HomeOtherBlock extends GeneralBetContainer {

    public HomeOtherBlock() {
        super(Arrays.asList(
                new HomeWinAndOverBlock(),
                new HomeWinAndUnderBlock()
        ), ContainerType.OTHER);
    }
}
