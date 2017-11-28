package com.savik.football.result_block.home.total;

import com.savik.GeneralBetContainer;
import com.savik.Match;
import com.savik.football.blocks.total.over.PeriodHomeOverBlock;
import com.savik.football.model.FootballMatch;

import java.util.Arrays;

/**
 * @author Savushkin Yauheni
 * @since 22.05.2017
 */
public class HomeTotalBlock extends GeneralBetContainer {

    public HomeTotalBlock() {
        super(Arrays.asList(
                new PeriodHomeOverBlock<FootballMatch>(footballMatch -> footballMatch.getMatchInfo().getMatch()),
                new PeriodHomeOverBlock<FootballMatch>(footballMatch -> footballMatch.getMatchInfo().getFirstPeriod()),
                new PeriodHomeOverBlock<FootballMatch>(footballMatch -> footballMatch.getMatchInfo().getSecondPeriod())
        ));
    }
}
