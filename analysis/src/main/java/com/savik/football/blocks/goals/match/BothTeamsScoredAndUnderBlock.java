package com.savik.football.blocks.goals.match;

import com.savik.football.blocks.GeneralBetContainer;

import java.util.Arrays;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class BothTeamsScoredAndUnderBlock extends GeneralBetContainer {

    public BothTeamsScoredAndUnderBlock() {
        super(Arrays.asList(
                new BothTeamsScoredAndUnderSingleBlock(3),
                new BothTeamsScoredAndUnderSingleBlock(4)
        ));
    }


}
