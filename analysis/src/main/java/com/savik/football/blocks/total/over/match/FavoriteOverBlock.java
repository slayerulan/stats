package com.savik.football.blocks.total.over.match;

import java.util.Arrays;

import com.savik.football.blocks.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class FavoriteOverBlock extends GeneralBetContainer {

    public FavoriteOverBlock() {
        super(Arrays.asList(
                new FavoriteOverSingleBlock(1),
                new FavoriteOverSingleBlock(2),
                new FavoriteOverSingleBlock(3),
                new FavoriteOverSingleBlock(4)
        ));
    }

    @Override
    public boolean isLeaf() {
        return false;
    }
}
