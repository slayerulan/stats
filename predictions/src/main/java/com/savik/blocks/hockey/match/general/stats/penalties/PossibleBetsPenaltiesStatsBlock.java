package com.savik.blocks.hockey.match.general.stats.penalties;


import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.PossibleBetContainer;
import com.savik.blocks.hockey.match.general.stats.*;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;

public class PossibleBetsPenaltiesStatsBlock extends PossibleBetContainer<HockeyMatch> {
    public PossibleBetsPenaltiesStatsBlock(MatchData homeMatchData, MatchData guestMatchData) {
        super(Arrays.asList(

        ), ContainerType.PENALTIES);
    }
}
