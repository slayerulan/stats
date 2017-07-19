package com.savik.football.blocks.handicap.match;

import java.util.Arrays;

import com.savik.football.blocks.MatchPeriodFavoriteBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class MatchFavoriteHandicapBlock extends MatchPeriodFavoriteBetContainer {

    public MatchFavoriteHandicapBlock() {
        super(Arrays.asList(
                new MatchFavoriteHandicapSingleBlock(1.5),
                new MatchFavoriteHandicapSingleBlock(2.5),
                new MatchFavoriteHandicapSingleBlock(3.5)
        ));
    }


}
