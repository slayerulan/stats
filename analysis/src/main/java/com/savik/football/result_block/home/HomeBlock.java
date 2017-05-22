package com.savik.football.result_block.home;

import java.util.Arrays;

import com.savik.football.blocks.GeneralBetContainer;
import com.savik.football.result_block.home.goals.HomeGoalsBlock;
import com.savik.football.result_block.home.handicap.HomeHandicapBlock;
import com.savik.football.result_block.home.total.HomeTotalBlock;

/**
 * @author Savushkin Yauheni
 * @since 22.05.2017
 */
public class HomeBlock extends GeneralBetContainer {

    public HomeBlock() {
        super(Arrays.asList(
                new HomeHandicapBlock(),
                new HomeTotalBlock(),
                new HomeGoalsBlock()
        ));
    }
}
