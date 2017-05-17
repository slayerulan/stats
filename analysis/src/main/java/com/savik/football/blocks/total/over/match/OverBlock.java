package com.savik.football.blocks.total.over.match;

import java.util.Arrays;

import com.savik.football.blocks.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class OverBlock extends GeneralBetContainer {

    public OverBlock() {
        super(Arrays.asList(
                new OverSingleBlock(0),
                new OverSingleBlock(1),
                new OverSingleBlock(2),
                new OverSingleBlock(3),
                new OverSingleBlock(4)
        ));
    }

    @Override
    public boolean isLeaf() {
        return false;
    }
}
