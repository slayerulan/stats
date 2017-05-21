package com.savik.football.blocks.total.under.match;

import java.util.Arrays;

import com.savik.football.blocks.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class MatchGuestUnderBlock extends GeneralBetContainer {

    public MatchGuestUnderBlock() {
        super(Arrays.asList(
                new MatchGuestUnderSingleBlock(0),
                new MatchGuestUnderSingleBlock(1),
                new MatchGuestUnderSingleBlock(2),
                new MatchGuestUnderSingleBlock(3),
                new MatchGuestUnderSingleBlock(4)
        ));
    }


}
