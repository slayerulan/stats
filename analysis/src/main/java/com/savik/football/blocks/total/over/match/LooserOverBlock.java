package com.savik.football.blocks.total.over.match;

import java.util.Arrays;

import com.savik.football.blocks.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class LooserOverBlock extends GeneralBetContainer {

    public LooserOverBlock() {
        super(Arrays.asList(
                new LooserOverSingleBlock(0),
                new LooserOverSingleBlock(1),
                new LooserOverSingleBlock(2),
                new LooserOverSingleBlock(3),
                new LooserOverSingleBlock(4)
        ));
    }


}
