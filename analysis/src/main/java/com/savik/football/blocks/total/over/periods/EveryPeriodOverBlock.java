package com.savik.football.blocks.total.over.periods;

import java.util.Arrays;

import com.savik.football.blocks.GeneralBetContainer;
import com.savik.football.blocks.total.over.second_period.SecondPeriodFavoriteOverSingleBlock;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class EveryPeriodOverBlock extends GeneralBetContainer {

    public EveryPeriodOverBlock() {
        super(Arrays.asList(
                new EveryPeriodOverSingleBlock(0.5),
                new EveryPeriodOverSingleBlock(1.5)
        ));
    }


}
