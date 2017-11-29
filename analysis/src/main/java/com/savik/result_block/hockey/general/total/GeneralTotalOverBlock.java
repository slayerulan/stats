package com.savik.result_block.hockey.general.total;

import com.savik.GeneralBetContainer;
import com.savik.PeriodBetContainer;
import com.savik.blocks.general.total.over.PeriodOverSingleBlock;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;


public class GeneralTotalOverBlock extends GeneralBetContainer {

    public GeneralTotalOverBlock() {
        super(
                new PeriodBetContainer<HockeyMatch>(Arrays.asList(
                        new PeriodOverSingleBlock(3.5),
                        new PeriodOverSingleBlock(4.5),
                        new PeriodOverSingleBlock(5.5),
                        new PeriodOverSingleBlock(6.5),
                        new PeriodOverSingleBlock(7.5)
                ), hockeyMatch -> hockeyMatch.getMatchInfo().getMatch())
        );
    }
}
