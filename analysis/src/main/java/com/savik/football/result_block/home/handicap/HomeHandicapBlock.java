package com.savik.football.result_block.home.handicap;

import java.util.Arrays;

import com.savik.football.blocks.GeneralBetContainer;
import com.savik.football.blocks.handicap.first_period.FirstPeriodHomeHandicapBlock;
import com.savik.football.blocks.handicap.match.MatchHomeHandicapBlock;
import com.savik.football.blocks.handicap.second_period.SecondPeriodHomeHandicapBlock;

/**
 * @author Savushkin Yauheni
 * @since 22.05.2017
 */
public class HomeHandicapBlock extends GeneralBetContainer {

    public HomeHandicapBlock() {
        super(Arrays.asList(
                new MatchHomeHandicapBlock(),
                new FirstPeriodHomeHandicapBlock(),
                new SecondPeriodHomeHandicapBlock()
        ));
    }
}
