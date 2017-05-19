package com.savik.football.blocks.total.under.match;

import java.util.Arrays;

import com.savik.football.blocks.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class MatchLooserUnderBlock extends GeneralBetContainer {

    public MatchLooserUnderBlock() {
        super(Arrays.asList(
                new MatchLooserUnderSingleBlock(0),
                new MatchLooserUnderSingleBlock(1),
                new MatchLooserUnderSingleBlock(2),
                new MatchLooserUnderSingleBlock(3),
                new MatchLooserUnderSingleBlock(4)
        ));
    }

    @Override
    public boolean isLeaf() {
        return false;
    }
}
