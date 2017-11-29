package com.savik.result_block.hockey.home.other;

import com.savik.GeneralBetContainer;
import com.savik.PeriodBetContainer;
import com.savik.bets.general.result.PeriodHomeWinner;
import com.savik.blocks.general.other.PeriodWinAndOverSingleBlock;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;


public class HomeWinAndOverBlock extends GeneralBetContainer {

    public HomeWinAndOverBlock() {
        super(
                new PeriodBetContainer<HockeyMatch>(Arrays.asList(
                        new PeriodWinAndOverSingleBlock<HockeyMatch>(3.5, new PeriodHomeWinner()),
                        new PeriodWinAndOverSingleBlock<HockeyMatch>(4.5, new PeriodHomeWinner())
                ), hockeyMatch -> hockeyMatch.getMatchInfo().getMatch())
        );
    }
}
