package com.savik.football.blocks.total.under.match;

import java.util.Arrays;

import com.savik.football.blocks.MatchPeriodFavoriteBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class MatchLooserUnderBlock extends MatchPeriodFavoriteBetContainer {

    public MatchLooserUnderBlock() {
        super(Arrays.asList(
                new MatchLooserUnderSingleBlock(0.5),
                new MatchLooserUnderSingleBlock(1.5),
                new MatchLooserUnderSingleBlock(2.5),
                new MatchLooserUnderSingleBlock(3.5),
                new MatchLooserUnderSingleBlock(4.5)
        ));
    }


}
