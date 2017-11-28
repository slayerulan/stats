package com.savik.football.result_block.home.total;

import com.savik.football.blocks.GeneralBetContainer;
import com.savik.football.blocks.total.over.PeriodHomeOverBlock;

import java.util.Arrays;

/**
 * @author Savushkin Yauheni
 * @since 22.05.2017
 */
public class HomeTotalBlock extends GeneralBetContainer {

    public HomeTotalBlock() {
        super(Arrays.asList(
                new PeriodHomeOverBlock(footballMatch -> footballMatch.getMatchInfo().getMatch()),
                new PeriodHomeOverBlock(footballMatch -> footballMatch.getMatchInfo().getFirstPeriod()),
                new PeriodHomeOverBlock(footballMatch -> footballMatch.getMatchInfo().getSecondPeriod())
        ));
    }
}
