package com.savik.blocks.football.goals.match;

import com.savik.GeneralBetContainer;
import com.savik.football.model.FootballMatch;

import java.util.Arrays;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class BothTeamsScoredAndUnderBlock extends GeneralBetContainer<FootballMatch> {

    public BothTeamsScoredAndUnderBlock() {
        super(Arrays.asList(
                new BothTeamsScoredAndUnderSingleBlock(3),
                new BothTeamsScoredAndUnderSingleBlock(4)
        ));
    }


}
