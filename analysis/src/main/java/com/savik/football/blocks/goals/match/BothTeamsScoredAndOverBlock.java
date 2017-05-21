package com.savik.football.blocks.goals.match;

import com.savik.football.blocks.GeneralBetContainer;

import java.util.Arrays;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class BothTeamsScoredAndOverBlock extends GeneralBetContainer {

    public BothTeamsScoredAndOverBlock() {
        super(Arrays.asList(
                new BothTeamsScoredAndOverSingleBlock(2),
                new BothTeamsScoredAndOverSingleBlock(3)
        ));
    }


}
