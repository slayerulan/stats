package com.savik.football.result_block.home.goals;

import com.savik.football.blocks.GeneralBetContainer;
import com.savik.football.blocks.goals.PeriodBothTeamsScoredBlock;
import com.savik.football.blocks.total.over.PeriodHomeOverSingleBlock;

import java.util.Arrays;

/**
 * @author Savushkin Yauheni
 * @since 22.05.2017
 */
public class HomeGoalsBlock extends GeneralBetContainer {

    public HomeGoalsBlock() {
        super(Arrays.asList(
                // команда забьет в матче
                new PeriodHomeOverSingleBlock(0.5, footballMatch -> footballMatch.getMatchInfo().getMatch()),

                // команда забьет в 1 тайме
                new PeriodHomeOverSingleBlock(0.5, footballMatch -> footballMatch.getMatchInfo().getFirstPeriod()),

                // команда забьет в 2 тайме
                new PeriodHomeOverSingleBlock(0.5, footballMatch -> footballMatch.getMatchInfo().getSecondPeriod()),

                // обе команды забьют
                new PeriodBothTeamsScoredBlock(footballMatch -> footballMatch.getMatchInfo().getMatch())
        ));
    }
}
