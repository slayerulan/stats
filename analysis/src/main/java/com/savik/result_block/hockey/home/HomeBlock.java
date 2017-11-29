package com.savik.result_block.hockey.home;

import com.savik.GeneralBetContainer;
import com.savik.result_block.hockey.home.other.HomeWinAndOverBlock;
import com.savik.result_block.hockey.home.other.HomeWinAndUnderBlock;
import com.savik.result_block.hockey.home.total.HomeTotalOverBlock;

import java.util.Arrays;


public class HomeBlock extends GeneralBetContainer {

    public HomeBlock() {
        super(Arrays.asList(
                new HomeTotalOverBlock(),
                new HomeWinAndOverBlock(),
                new HomeWinAndUnderBlock()
        ));
    }
}
