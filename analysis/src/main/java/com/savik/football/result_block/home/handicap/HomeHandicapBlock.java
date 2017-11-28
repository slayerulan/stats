package com.savik.football.result_block.home.handicap;

import com.savik.GeneralBetContainer;
import com.savik.football.blocks.handicap.PeriodHomeHandicapBlock;
import com.savik.football.model.FootballMatch;

import java.util.Arrays;

/**
 * @author Savushkin Yauheni
 * @since 22.05.2017
 */
public class HomeHandicapBlock extends GeneralBetContainer {

    public HomeHandicapBlock() {
        super(Arrays.asList(
                new PeriodHomeHandicapBlock<FootballMatch>(footballMatch -> footballMatch.getMatchInfo().getMatch()),
                new PeriodHomeHandicapBlock<FootballMatch>(footballMatch -> footballMatch.getMatchInfo().getFirstPeriod()),
                new PeriodHomeHandicapBlock<FootballMatch>(footballMatch -> footballMatch.getMatchInfo().getSecondPeriod())
        ));
    }
}
