package com.savik.football.blocks.total.over.match;

import java.util.Arrays;

import com.savik.football.blocks.MatchPeriodBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class OverBlock extends MatchPeriodBetContainer {

    public OverBlock() {
        super(Arrays.asList(
                new OverSingleBlock(0.5),
                new OverSingleBlock(1.5),
                new OverSingleBlock(2.5),
                new OverSingleBlock(3.5),
                new OverSingleBlock(4.5)
        ));
    }


}
