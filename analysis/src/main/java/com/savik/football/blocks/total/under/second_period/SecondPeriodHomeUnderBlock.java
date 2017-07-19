package com.savik.football.blocks.total.under.second_period;

import java.util.Arrays;

import com.savik.football.blocks.SecondPeriodBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class SecondPeriodHomeUnderBlock extends SecondPeriodBetContainer {

    public SecondPeriodHomeUnderBlock() {
        super(Arrays.asList(
                new SecondPeriodHomeUnderSingleBlock(0.5),
                new SecondPeriodHomeUnderSingleBlock(1.5),
                new SecondPeriodHomeUnderSingleBlock(2.5),
                new SecondPeriodHomeUnderSingleBlock(3.5),
                new SecondPeriodHomeUnderSingleBlock(4.5)
        ));
    }


}
