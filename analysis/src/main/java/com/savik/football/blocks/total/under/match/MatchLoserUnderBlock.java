package com.savik.football.blocks.total.under.match;

import java.util.Arrays;

import com.savik.football.blocks.MatchPeriodFavoriteBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class MatchLoserUnderBlock extends MatchPeriodFavoriteBetContainer {

    public MatchLoserUnderBlock() {
        super(Arrays.asList(
                new MatchLoserUnderSingleBlock(0.5),
                new MatchLoserUnderSingleBlock(1.5),
                new MatchLoserUnderSingleBlock(2.5),
                new MatchLoserUnderSingleBlock(3.5),
                new MatchLoserUnderSingleBlock(4.5)
        ));
    }


}
