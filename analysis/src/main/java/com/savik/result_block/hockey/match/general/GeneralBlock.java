package com.savik.result_block.hockey.match.general;

import com.savik.ContainerType;
import com.savik.GeneralBetContainer;
import com.savik.MatchData;
import com.savik.hockey.model.HockeyMatch;
import com.savik.result_block.hockey.match.general.other.GeneralOtherBlock;
import com.savik.result_block.hockey.match.general.stats.GeneralStatsBlock;
import com.savik.result_block.hockey.match.general.total.GeneralTotalBlock;

import java.util.Arrays;

/**
 * @author Savushkin Yauheni
 * @since 22.05.2017
 */
public class GeneralBlock extends GeneralBetContainer<HockeyMatch> {

    public GeneralBlock(ContainerType type, MatchData matchData) {
        super(Arrays.asList(
                new GeneralTotalBlock(matchData),
                new GeneralOtherBlock(matchData),
                new GeneralStatsBlock()
        ), type);
    }
}
