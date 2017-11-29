package com.savik.result_block.hockey.home.total;

import com.savik.GeneralBetContainer;
import com.savik.PeriodBetContainer;
import com.savik.blocks.general.total.over.PeriodHomeOverBlock;
import com.savik.blocks.general.total.over.PeriodHomeOverSingleBlock;
import com.savik.blocks.general.total.over.PeriodOverSingleBlock;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;


public class HomeTotalOverBlock extends GeneralBetContainer {

    public HomeTotalOverBlock() {
        super(
                new PeriodBetContainer<HockeyMatch>(Arrays.asList(
                        new PeriodHomeOverSingleBlock(2.5),
                        new PeriodHomeOverSingleBlock(3.5),
                        new PeriodHomeOverSingleBlock(4.5),
                        new PeriodHomeOverSingleBlock(5.5)
                ), hockeyMatch -> hockeyMatch.getMatchInfo().getMatch())
        );
    }
}
