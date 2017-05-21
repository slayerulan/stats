package com.savik.football.blocks.handicap.match;

import java.util.Arrays;

import com.savik.football.blocks.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class MatchLoserHandicapBlock extends GeneralBetContainer {

    public MatchLoserHandicapBlock() {
        super(Arrays.asList(
                new MatchLoserHandicapSingleBlock(1),
                new MatchLoserHandicapSingleBlock(2),
                new MatchLoserHandicapSingleBlock(3)
        ));
    }


}
