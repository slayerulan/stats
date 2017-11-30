package com.savik.result_block.hockey;

import com.savik.ContainerType;
import com.savik.GeneralBetContainer;
import com.savik.MatchData;
import com.savik.result_block.hockey.general.GeneralBlock;
import com.savik.result_block.hockey.guest.GuestBlock;
import com.savik.result_block.hockey.home.HomeBlock;

import java.util.Arrays;


public class ResultBlock extends GeneralBetContainer {

    public ResultBlock(MatchData matchData) {
        super(
                Arrays.asList(
                        new GeneralBlock(matchData),
                        new HomeBlock(),
                        new GuestBlock()
                ), ContainerType.ROOT
        );
    }
}
