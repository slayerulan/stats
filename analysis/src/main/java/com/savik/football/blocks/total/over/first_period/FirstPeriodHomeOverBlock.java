package com.savik.football.blocks.total.over.first_period;

import java.util.Arrays;

import com.savik.football.blocks.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class FirstPeriodHomeOverBlock extends GeneralBetContainer {

    public FirstPeriodHomeOverBlock() {
        super(Arrays.asList(
                new FirstPeriodHomeOverSingleBlock(0.5),
                new FirstPeriodHomeOverSingleBlock(1.5),
                new FirstPeriodHomeOverSingleBlock(2.5),
                new FirstPeriodHomeOverSingleBlock(3.5),
                new FirstPeriodHomeOverSingleBlock(4.5)
        ), "Тотал команды в 1 тайме при игре дома");
    }


}
