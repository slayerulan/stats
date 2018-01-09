package com.savik.blocks.hockey.match.general.stats.penalties.match;


import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.PossibleBetContainer;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;

public class PossibleBetsMatchPenaltiesStatsBlock extends PossibleBetContainer<HockeyMatch> {
    public PossibleBetsMatchPenaltiesStatsBlock(MatchData homeMatchData, MatchData guestMatchData) {
        super(Arrays.asList(
                new MinorPenaltiesTimeTotalOverPossibleBetBlock(),
                new TeamMinorPenaltiesTimeTotalOverPossibleBetBlock(homeMatchData, guestMatchData),
                new OpposingTeamMinorPenaltiesTimeTotalOverPossibleBetBlock(homeMatchData, guestMatchData),
                new TeamMinorPenaltiesTimeNotLoosePossibleBetBlock(homeMatchData, guestMatchData),
                new OpposingTeamMinorPenaltiesTimeNotLoosePossibleBetBlock(homeMatchData, guestMatchData),
                new TeamMinorPenaltiesTimeHandicapPossibleBetBlock(homeMatchData, guestMatchData),
                new OpposingTeamMinorPenaltiesTimeHandicapPossibleBetBlock(homeMatchData, guestMatchData)
        ), ContainerType.MATCH);
    }
}
