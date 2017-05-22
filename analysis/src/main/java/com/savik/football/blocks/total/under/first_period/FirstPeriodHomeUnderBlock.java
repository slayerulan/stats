package com.savik.football.blocks.total.under.first_period;

import java.util.Arrays;

import com.savik.football.blocks.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class FirstPeriodHomeUnderBlock extends GeneralBetContainer {

    public FirstPeriodHomeUnderBlock() {
        super(Arrays.asList(
                new FirstPeriodHomeUnderSingleBlock(0.5),
                new FirstPeriodHomeUnderSingleBlock(1.5),
                new FirstPeriodHomeUnderSingleBlock(2.5),
                new FirstPeriodHomeUnderSingleBlock(3.5),
                new FirstPeriodHomeUnderSingleBlock(4.5)
        ));
    }


}
