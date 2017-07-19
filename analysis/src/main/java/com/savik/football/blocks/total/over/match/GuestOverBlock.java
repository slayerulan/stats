package com.savik.football.blocks.total.over.match;

import java.util.Arrays;

import com.savik.football.blocks.MatchPeriodBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class GuestOverBlock extends MatchPeriodBetContainer {

    public GuestOverBlock() {
        super(Arrays.asList(
                new GuestOverSingleBlock(0.5),
                new GuestOverSingleBlock(1.5),
                new GuestOverSingleBlock(2.5),
                new GuestOverSingleBlock(3.5),
                new GuestOverSingleBlock(4.5)
        ));
    }


}
