package com.savik.football.blocks.handicap.first_period;

import java.util.Arrays;

import com.savik.football.blocks.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class FirstPeriodHomeHandicapBlock extends GeneralBetContainer {

    public FirstPeriodHomeHandicapBlock() {
        super(Arrays.asList(
                new FirstPeriodHomeHandicapSingleBlock(-2.5),
                new FirstPeriodHomeHandicapSingleBlock(-1.5),
                new FirstPeriodHomeHandicapSingleBlock(1.5),
                new FirstPeriodHomeHandicapSingleBlock(2.5)
        ), "Фора в 1 тайме при игре дома");
    }


}
