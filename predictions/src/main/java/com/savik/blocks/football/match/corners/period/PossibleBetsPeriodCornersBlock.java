package com.savik.blocks.football.match.corners.period;


import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.Period;
import com.savik.PossibleBetContainer;
import com.savik.blocks.football.match.corners.*;
import com.savik.blocks.football.match.corners.match.*;
import com.savik.football.model.FootballMatch;

import java.util.Arrays;
import java.util.function.Function;

public class PossibleBetsPeriodCornersBlock extends PossibleBetContainer<FootballMatch> {
    public PossibleBetsPeriodCornersBlock(MatchData homeMatchData, MatchData guestMatchData,
                                          Function<FootballMatch, Period> period, ContainerType containerType) {
        super(Arrays.asList(
                new PeriodCornersTotalOverPossibleBetBlock(period),
                new PeriodCornersTotalUnderPossibleBetBlock(period),
                new TeamCornersTotalOverPossibleBetBlock(homeMatchData, guestMatchData, period),
                new OpposingTeamCornersTotalOverPossibleBetBlock(homeMatchData, guestMatchData, period),
                new TeamCornersNotLoosePossibleBetBlock(homeMatchData, guestMatchData, period),
                new OpposingTeamCornersNotLoosePossibleBetBlock(homeMatchData, guestMatchData, period),
                new TeamCornersHandicapPossibleBetBlock(homeMatchData, guestMatchData, period),
                new OpposingTeamCornersHandicapPossibleBetBlock(homeMatchData, guestMatchData, period)
        ), containerType);
    }
}
