package com.savik.football.blocks.handicap.match;

import java.util.Arrays;

import com.savik.football.blocks.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class MatchGuestHandicapBlock extends GeneralBetContainer {

    public MatchGuestHandicapBlock() {
        super(Arrays.asList(
                new MatchGuestHandicapSingleBlock(1.5),
                new MatchGuestHandicapSingleBlock(2.5),
                new MatchGuestHandicapSingleBlock(3.5)
        ));
    }


}
