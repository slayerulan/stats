package com.savik.result_block.hockey.match.general.periods;

import com.savik.GeneralBetContainer;
import com.savik.MatchData;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;

import static com.savik.ContainerType.*;


public class GeneralPeriodsBlock extends GeneralBetContainer {

    public GeneralPeriodsBlock(MatchData matchData) {
        super(Arrays.asList(
                new GeneralPeriodBlock(matchData, HockeyMatch.FIRST_PERIOD, FIRST_PERIOD),
                new GeneralPeriodBlock(matchData, HockeyMatch.SECOND_PERIOD, SECOND_PERIOD),
                new GeneralPeriodBlock(matchData, HockeyMatch.THIRD_PERIOD, THIRD_PERIOD)
        ), PERIODS);
    }
}
