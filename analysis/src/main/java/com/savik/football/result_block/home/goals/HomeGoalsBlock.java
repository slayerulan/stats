package com.savik.football.result_block.home.goals;

import java.util.Arrays;

import com.savik.football.blocks.GeneralBetContainer;
import com.savik.football.blocks.goals.match.BothTeamsScoredBlock;
import com.savik.football.blocks.total.over.first_period.FirstPeriodHomeOverSingleBlock;
import com.savik.football.blocks.total.over.match.HomeOverSingleBlock;
import com.savik.football.blocks.total.over.second_period.SecondPeriodHomeOverSingleBlock;

/**
 * @author Savushkin Yauheni
 * @since 22.05.2017
 */
public class HomeGoalsBlock extends GeneralBetContainer {

    public HomeGoalsBlock() {
        super(Arrays.asList(
                // команда забьет в матче
                new HomeOverSingleBlock(0.5),
                // команда забьет в 1 тайме
                new FirstPeriodHomeOverSingleBlock(0.5),
                // команда забьет в 1 тайме
                new SecondPeriodHomeOverSingleBlock(0.5),
                // обе команды забьют
                new BothTeamsScoredBlock()
        ), "Голы при игре дома");
    }
}
