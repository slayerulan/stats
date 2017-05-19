package com.savik.football.blocks.total.under.match;

import java.util.Arrays;

import com.savik.football.blocks.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class MatchFavoriteUnderBlock extends GeneralBetContainer {

    public MatchFavoriteUnderBlock() {
        super(Arrays.asList(
                new MatchFavoriteUnderSingleBlock(0),
                new MatchFavoriteUnderSingleBlock(1),
                new MatchFavoriteUnderSingleBlock(2),
                new MatchFavoriteUnderSingleBlock(3),
                new MatchFavoriteUnderSingleBlock(4)
        ));
    }

    @Override
    public boolean isLeaf() {
        return false;
    }
}
