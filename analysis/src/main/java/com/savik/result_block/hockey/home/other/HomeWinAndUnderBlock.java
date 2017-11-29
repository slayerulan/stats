package com.savik.result_block.hockey.home.other;

import com.savik.GeneralBetContainer;
import com.savik.PeriodBetContainer;
import com.savik.bets.general.result.PeriodHomeWinner;
import com.savik.blocks.general.other.PeriodWinAndOverSingleBlock;
import com.savik.blocks.general.other.PeriodWinAndUnderSingleBlock;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;


public class HomeWinAndUnderBlock extends GeneralBetContainer {

    public HomeWinAndUnderBlock() {
        super(
                new PeriodBetContainer<HockeyMatch>(Arrays.asList(
                        new PeriodWinAndUnderSingleBlock<HockeyMatch>(4.5, new PeriodHomeWinner())
                ), hockeyMatch -> hockeyMatch.getMatchInfo().getMatch())
        );
    }
}
