package com.savik.result_block.hockey.match.general;

import com.savik.ContainerType;
import com.savik.GeneralBetContainer;
import com.savik.MatchData;
import com.savik.result_block.hockey.match.general.other.GeneralOtherBlock;
import com.savik.result_block.hockey.match.general.stats.GeneralStatsBlock;
import com.savik.result_block.hockey.match.general.total.GeneralTotalBlock;

import java.util.Arrays;

/**
 * @author Savushkin Yauheni
 * @since 22.05.2017
 */
public class GeneralBlock extends GeneralBetContainer {

    public GeneralBlock(MatchData matchData) {
        super(Arrays.asList(
                new GeneralOtherBlock(),
                new GeneralTotalBlock(matchData),
                new GeneralStatsBlock()
        ), ContainerType.GENERAL);
    }
}
