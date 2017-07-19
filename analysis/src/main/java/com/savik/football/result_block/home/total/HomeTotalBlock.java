package com.savik.football.result_block.home.total;

import java.util.Arrays;

import com.savik.football.blocks.GeneralBetContainer;
import com.savik.football.blocks.total.over.first_period.FirstPeriodHomeOverBlock;
import com.savik.football.blocks.total.over.match.HomeOverBlock;
import com.savik.football.blocks.total.over.second_period.SecondPeriodHomeOverBlock;

/**
 * @author Savushkin Yauheni
 * @since 22.05.2017
 */
public class HomeTotalBlock extends GeneralBetContainer {

    public HomeTotalBlock() {
        super(Arrays.asList(
                new HomeOverBlock(),
                new FirstPeriodHomeOverBlock(),
                new SecondPeriodHomeOverBlock()
        ));
    }
}
