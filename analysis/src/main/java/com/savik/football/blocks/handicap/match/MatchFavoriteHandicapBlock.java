package com.savik.football.blocks.handicap.match;

import java.util.Arrays;

import com.savik.football.blocks.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class MatchFavoriteHandicapBlock extends GeneralBetContainer {

    public MatchFavoriteHandicapBlock() {
        super(Arrays.asList(
                new MatchFavoriteHandicapSingleBlock(1),
                new MatchFavoriteHandicapSingleBlock(2),
                new MatchFavoriteHandicapSingleBlock(3)
        ));
    }


}
