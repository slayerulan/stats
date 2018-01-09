package com.savik.blocks.hockey.match.general.stats.penalties;


import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.PossibleBetContainer;
import com.savik.blocks.hockey.match.general.stats.penalties.match.PossibleBetsMatchPenaltiesStatsBlock;
import com.savik.blocks.hockey.match.general.stats.penalties.period.PossibleBetsPeriodPenaltiesStatsBlock;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;

public class PossibleBetsPenaltiesStatsBlock extends PossibleBetContainer<HockeyMatch> {
    public PossibleBetsPenaltiesStatsBlock(MatchData homeMatchData, MatchData guestMatchData) {
        super(Arrays.asList(
                new PossibleBetsMatchPenaltiesStatsBlock(homeMatchData, guestMatchData),
                new PossibleBetsPeriodPenaltiesStatsBlock(homeMatchData, guestMatchData, HockeyMatch.FIRST_PERIOD, ContainerType.FIRST_PERIOD)
        ), ContainerType.PENALTIES);
    }
}
