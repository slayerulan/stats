package com.savik.result_block.football.home.total;

import com.savik.GeneralBetContainer;
import com.savik.blocks.general.total.over.PeriodHomeOverBlock;
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
