package com.savik.general.blocks.goals.match;

import com.savik.GeneralBetContainer;
import com.savik.football.model.FootballMatch;

import java.util.Arrays;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class BothTeamsScoredAndOverBlock extends GeneralBetContainer<FootballMatch> {

    public BothTeamsScoredAndOverBlock() {
        super(Arrays.asList(
                new BothTeamsScoredAndOverSingleBlock(2),
                new BothTeamsScoredAndOverSingleBlock(3)
        ));
    }


}
