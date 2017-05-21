package com.savik.football.blocks.total.under.second_period;

import java.util.Arrays;

import com.savik.football.blocks.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class SecondPeriodHomeUnderBlock extends GeneralBetContainer {

    public SecondPeriodHomeUnderBlock() {
        super(Arrays.asList(
                new SecondPeriodHomeUnderSingleBlock(0),
                new SecondPeriodHomeUnderSingleBlock(1),
                new SecondPeriodHomeUnderSingleBlock(2),
                new SecondPeriodHomeUnderSingleBlock(3),
                new SecondPeriodHomeUnderSingleBlock(4)
        ));
    }


}
