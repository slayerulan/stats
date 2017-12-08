package com.savik.blocks.hockey.match.general.periods;


import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.PossibleBetContainer;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;

public class PossibleBetsPeriodsBlock extends PossibleBetContainer<HockeyMatch> {
    public PossibleBetsPeriodsBlock(MatchData homeMatchData, MatchData guestMatchData) {
        super(Arrays.asList(
                new PossibleBetsPeriodBlock(homeMatchData, guestMatchData, HockeyMatch.FIRST_PERIOD, ContainerType.FIRST_PERIOD),
                new PossibleBetsPeriodBlock(homeMatchData, guestMatchData, HockeyMatch.SECOND_PERIOD, ContainerType.SECOND_PERIOD),
                new PossibleBetsPeriodBlock(homeMatchData, guestMatchData, HockeyMatch.THIRD_PERIOD, ContainerType.THIRD_PERIOD)
        ), ContainerType.PERIODS);
    }
}
