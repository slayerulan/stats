package com.savik.football.blocks.total.under.match;

import java.util.Arrays;

import com.savik.football.blocks.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class MatchHomeUnderBlock extends GeneralBetContainer {

    public MatchHomeUnderBlock() {
        super(Arrays.asList(
                new MatchHomeUnderSingleBlock(0.5),
                new MatchHomeUnderSingleBlock(1.5),
                new MatchHomeUnderSingleBlock(2.5),
                new MatchHomeUnderSingleBlock(3.5),
                new MatchHomeUnderSingleBlock(4.5)
        ));
    }


}