package com.savik.result_block.football.home;

import java.util.Arrays;

import com.savik.GeneralBetContainer;
import com.savik.result_block.football.home.goals.HomeGoalsBlock;
import com.savik.result_block.football.home.handicap.HomeHandicapBlock;
import com.savik.result_block.football.home.total.HomeTotalBlock;

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
