package com.savik.blocks.hockey.match.general.stats.penalties.match;


import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.PossibleBetContainer;
import com.savik.blocks.hockey.match.general.stats.penalties.*;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;

public class PossibleBetsMatchPenaltiesStatsBlock extends PossibleBetContainer<HockeyMatch> {
    public PossibleBetsMatchPenaltiesStatsBlock(MatchData homeMatchData, MatchData guestMatchData) {
        super(Arrays.asList(
                new MinorPenaltiesTimeTotalOverPossibleBetBlock(),
                new TeamMinorPenaltiesTimeTotalOverPossibleBetBlock(homeMatchData, guestMatchData, HockeyMatch.MATCH),
                new OpposingTeamMinorPenaltiesTimeTotalOverPossibleBetBlock(homeMatchData, guestMatchData, HockeyMatch.MATCH),
                new TeamMinorPenaltiesTimeNotLoosePossibleBetBlock(homeMatchData, guestMatchData, HockeyMatch.MATCH),
                new OpposingTeamMinorPenaltiesTimeNotLoosePossibleBetBlock(homeMatchData, guestMatchData, HockeyMatch.MATCH),
                new TeamMinorPenaltiesTimeHandicapPossibleBetBlock(homeMatchData, guestMatchData, HockeyMatch.MATCH),
                new OpposingTeamMinorPenaltiesTimeHandicapPossibleBetBlock(homeMatchData, guestMatchData, HockeyMatch.MATCH)
        ), ContainerType.MATCH);
    }
}