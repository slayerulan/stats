package com.savik.football.blocks.total.over.match;

import java.util.Arrays;

import com.savik.football.blocks.MatchPeriodFavoriteBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class FavoriteOverBlock extends MatchPeriodFavoriteBetContainer {

    public FavoriteOverBlock() {
        super(Arrays.asList(
                new FavoriteOverSingleBlock(0.5),
                new FavoriteOverSingleBlock(1.5),
                new FavoriteOverSingleBlock(2.5),
                new FavoriteOverSingleBlock(3.5),
                new FavoriteOverSingleBlock(4.5)
        ));
    }


}
