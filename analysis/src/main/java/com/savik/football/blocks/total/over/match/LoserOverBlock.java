package com.savik.football.blocks.total.over.match;

import java.util.Arrays;

import com.savik.football.blocks.MatchPeriodFavoriteBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class LoserOverBlock extends MatchPeriodFavoriteBetContainer {

    public LoserOverBlock() {
        super(Arrays.asList(
                new LoserOverSingleBlock(0.5),
                new LoserOverSingleBlock(1.5),
                new LoserOverSingleBlock(2.5),
                new LoserOverSingleBlock(3.5),
                new LoserOverSingleBlock(4.5)
        ));
    }


}
