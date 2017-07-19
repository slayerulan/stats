package com.savik.football.blocks.total.over.match;

import java.util.Arrays;

import com.savik.football.blocks.MatchPeriodBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class HomeOverBlock extends MatchPeriodBetContainer {

    public HomeOverBlock() {
        super(Arrays.asList(
                new HomeOverSingleBlock(0.5),
                new HomeOverSingleBlock(1.5),
                new HomeOverSingleBlock(2.5),
                new HomeOverSingleBlock(3.5),
                new HomeOverSingleBlock(4.5)
        ));
    }


}
