package com.savik.football.blocks.handicap.second_period;

import java.util.Arrays;

import com.savik.football.blocks.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class SecondPeriodHomeHandicapBlock extends GeneralBetContainer {

    public SecondPeriodHomeHandicapBlock() {
        super(Arrays.asList(
                new SecondPeriodHomeHandicapSingleBlock(-2.5),
                new SecondPeriodHomeHandicapSingleBlock(-1.5),
                new SecondPeriodHomeHandicapSingleBlock(1.5),
                new SecondPeriodHomeHandicapSingleBlock(2.5)
        ), "Фора во 2 тайме при игре дома");
    }


}
