package com.savik.football.blocks.total.under.match;

import java.util.Arrays;

import com.savik.football.blocks.MatchPeriodBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class MatchUnderBlock extends MatchPeriodBetContainer {

    public MatchUnderBlock() {
        super(Arrays.asList(
                new MatchUnderSingleBlock(0.5),
                new MatchUnderSingleBlock(1.5),
                new MatchUnderSingleBlock(2.5),
                new MatchUnderSingleBlock(3.5),
                new MatchUnderSingleBlock(4.5)
        ));
    }


}
