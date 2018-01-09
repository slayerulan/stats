package com.savik.blocks.football.match.corners.period;


import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.Period;
import com.savik.PossibleBetContainer;
import com.savik.blocks.football.match.corners.OpposingTeamCornersHandicapPossibleBetBlock;
import com.savik.blocks.football.match.corners.OpposingTeamCornersNotLoosePossibleBetBlock;
import com.savik.blocks.football.match.corners.TeamCornersHandicapPossibleBetBlock;
import com.savik.blocks.football.match.corners.TeamCornersNotLoosePossibleBetBlock;
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
                new TeamCornersNotLoosePossibleBetBlock(homeMatchData, guestMatchData),
                new OpposingTeamCornersNotLoosePossibleBetBlock(homeMatchData, guestMatchData),
                new TeamCornersHandicapPossibleBetBlock(homeMatchData, guestMatchData, period),
                new OpposingTeamCornersHandicapPossibleBetBlock(homeMatchData, guestMatchData, period)
        ), containerType);
    }
}
