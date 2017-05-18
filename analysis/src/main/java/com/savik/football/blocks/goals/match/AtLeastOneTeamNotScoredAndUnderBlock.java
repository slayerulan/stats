package com.savik.football.blocks.goals.match;

import com.savik.football.blocks.GeneralBetContainer;

import java.util.Arrays;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class AtLeastOneTeamNotScoredAndUnderBlock extends GeneralBetContainer {

    public AtLeastOneTeamNotScoredAndUnderBlock() {
        super(Arrays.asList(
                new AtLeastOneTeamNotScoredAndUnderSingleBlock(3),
                new AtLeastOneTeamNotScoredAndUnderSingleBlock(4)
        ));
    }

    @Override
    public boolean isLeaf() {
        return false;
    }
}
