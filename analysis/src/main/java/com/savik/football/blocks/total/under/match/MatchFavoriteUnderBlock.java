package com.savik.football.blocks.total.under.match;

import java.util.Arrays;

import com.savik.football.blocks.MatchPeriodFavoriteBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class MatchFavoriteUnderBlock extends MatchPeriodFavoriteBetContainer {

    public MatchFavoriteUnderBlock() {
        super(Arrays.asList(
                new MatchFavoriteUnderSingleBlock(0.5),
                new MatchFavoriteUnderSingleBlock(1.5),
                new MatchFavoriteUnderSingleBlock(2.5),
                new MatchFavoriteUnderSingleBlock(3.5),
                new MatchFavoriteUnderSingleBlock(4.5)
        ));
    }


}
