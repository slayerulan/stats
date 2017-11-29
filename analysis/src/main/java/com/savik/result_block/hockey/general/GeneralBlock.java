package com.savik.result_block.hockey.general;

import com.savik.GeneralBetContainer;
import com.savik.result_block.football.home.goals.HomeGoalsBlock;
import com.savik.result_block.football.home.handicap.HomeHandicapBlock;
import com.savik.result_block.football.home.total.HomeTotalBlock;

import java.util.Arrays;

/**
 * @author Savushkin Yauheni
 * @since 22.05.2017
 */
public class GeneralBlock extends GeneralBetContainer {

    public GeneralBlock() {
        super(Arrays.asList(
                new HomeHandicapBlock(),
                new HomeTotalBlock(),
                new HomeGoalsBlock()
        ));
    }
}
