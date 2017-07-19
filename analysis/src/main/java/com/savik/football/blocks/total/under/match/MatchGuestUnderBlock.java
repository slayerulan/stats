package com.savik.football.blocks.total.under.match;

import java.util.Arrays;

import com.savik.football.blocks.MatchPeriodBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class MatchGuestUnderBlock extends MatchPeriodBetContainer {

    public MatchGuestUnderBlock() {
        super(Arrays.asList(
                new MatchGuestUnderSingleBlock(0.5),
                new MatchGuestUnderSingleBlock(1.5),
                new MatchGuestUnderSingleBlock(2.5),
                new MatchGuestUnderSingleBlock(3.5),
                new MatchGuestUnderSingleBlock(4.5)
        ));
    }


}
