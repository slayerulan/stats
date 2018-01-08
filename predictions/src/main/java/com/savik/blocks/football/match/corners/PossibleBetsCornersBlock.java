package com.savik.blocks.football.match.corners;


import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.PossibleBetContainer;
import com.savik.football.model.FootballMatch;

import java.util.Arrays;

public class PossibleBetsCornersBlock extends PossibleBetContainer<FootballMatch> {
    public PossibleBetsCornersBlock(MatchData homeMatchData, MatchData guestMatchData) {
        super(Arrays.asList(
                new PeriodCornersTotalOverPossibleBetBlock(),
                new PeriodCornersTotalUnderPossibleBetBlock(),
                new PeriodTeamCornersTotalOverPossibleBetBlock(homeMatchData, guestMatchData),
                new PeriodOpposingTeamCornersTotalOverPossibleBetBlock(homeMatchData, guestMatchData),
                new TeamCornersNotLoosePossibleBetBlock(homeMatchData, guestMatchData),
                new OpposingTeamCornersNotLoosePossibleBetBlock(homeMatchData, guestMatchData),
                new PeriodTeamCornersHandicapPossibleBetBlock(homeMatchData, guestMatchData),
                new PeriodOpposingTeamCornersHandicapPossibleBetBlock(homeMatchData, guestMatchData)
        ), ContainerType.CORNERS);
    }
}
