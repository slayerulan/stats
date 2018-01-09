package com.savik.blocks.hockey.match.general.stats.penalties.period;


import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.Period;
import com.savik.PossibleBetContainer;
import com.savik.blocks.hockey.match.general.stats.penalties.*;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;
import java.util.function.Function;

public class PossibleBetsPeriodPenaltiesStatsBlock extends PossibleBetContainer<HockeyMatch> {
    public PossibleBetsPeriodPenaltiesStatsBlock(MatchData homeMatchData, MatchData guestMatchData,
                                                 Function<HockeyMatch, Period> period, ContainerType containerType) {
        super(Arrays.asList(
                new PeriodMinorPenaltiesTimeTotalOverPossibleBetBlock(period),
                new TeamMinorPenaltiesTimeTotalOverPossibleBetBlock(homeMatchData, guestMatchData, period),
                new OpposingTeamMinorPenaltiesTimeTotalOverPossibleBetBlock(homeMatchData, guestMatchData, period),
                new TeamMinorPenaltiesTimeNotLoosePossibleBetBlock(homeMatchData, guestMatchData, period),
                new OpposingTeamMinorPenaltiesTimeNotLoosePossibleBetBlock(homeMatchData, guestMatchData, period),
                new TeamMinorPenaltiesTimeHandicapPossibleBetBlock(homeMatchData, guestMatchData, period),
                new OpposingTeamMinorPenaltiesTimeHandicapPossibleBetBlock(homeMatchData, guestMatchData, period)
        ), containerType);
    }
}
