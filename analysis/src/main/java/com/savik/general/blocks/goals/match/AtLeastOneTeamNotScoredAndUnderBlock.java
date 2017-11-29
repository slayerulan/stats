package com.savik.general.blocks.goals.match;

import com.savik.GeneralBetContainer;
import com.savik.football.model.FootballMatch;

import java.util.Arrays;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class AtLeastOneTeamNotScoredAndUnderBlock extends GeneralBetContainer<FootballMatch> {

    public AtLeastOneTeamNotScoredAndUnderBlock() {
        super(Arrays.asList(
                new AtLeastOneTeamNotScoredAndUnderSingleBlock(3),
                new AtLeastOneTeamNotScoredAndUnderSingleBlock(4)
        ));
    }


}
