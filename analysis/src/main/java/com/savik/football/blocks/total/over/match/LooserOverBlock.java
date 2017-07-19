package com.savik.football.blocks.total.over.match;

import java.util.Arrays;

import com.savik.football.blocks.MatchPeriodFavoriteBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class LooserOverBlock extends MatchPeriodFavoriteBetContainer {

    public LooserOverBlock() {
        super(Arrays.asList(
                new LooserOverSingleBlock(0.5),
                new LooserOverSingleBlock(1.5),
                new LooserOverSingleBlock(2.5),
                new LooserOverSingleBlock(3.5),
                new LooserOverSingleBlock(4.5)
        ));
    }


}
