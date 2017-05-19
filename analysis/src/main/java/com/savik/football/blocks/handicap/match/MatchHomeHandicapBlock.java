package com.savik.football.blocks.handicap.match;

import java.util.Arrays;

import com.savik.football.blocks.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class MatchHomeHandicapBlock extends GeneralBetContainer {

    public MatchHomeHandicapBlock() {
        super(Arrays.asList(
                new MatchHomeHandicapSingleBlock(1),
                new MatchHomeHandicapSingleBlock(2),
                new MatchHomeHandicapSingleBlock(3)
        ));
    }

    @Override
    public boolean isLeaf() {
        return false;
    }
}
