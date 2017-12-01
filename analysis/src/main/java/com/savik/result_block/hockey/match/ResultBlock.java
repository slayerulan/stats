package com.savik.result_block.hockey.match;

import com.savik.ContainerType;
import com.savik.GeneralBetContainer;
import com.savik.MatchData;
import com.savik.result_block.hockey.match.general.GeneralBlock;

import java.util.Arrays;


public class ResultBlock extends GeneralBetContainer {

    public ResultBlock(MatchData matchData) {
        super(
                Arrays.asList(
                        new GeneralBlock(matchData)
                ), ContainerType.ROOT
        );
    }
}
