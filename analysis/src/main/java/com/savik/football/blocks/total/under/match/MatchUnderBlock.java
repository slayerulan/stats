package com.savik.football.blocks.total.under.match;

import java.util.Arrays;

import com.savik.football.blocks.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class MatchUnderBlock extends GeneralBetContainer {

    public MatchUnderBlock() {
        super(Arrays.asList(
                new MatchUnderSingleBlock(0),
                new MatchUnderSingleBlock(1),
                new MatchUnderSingleBlock(2),
                new MatchUnderSingleBlock(3),
                new MatchUnderSingleBlock(4)
        ));
    }


}
