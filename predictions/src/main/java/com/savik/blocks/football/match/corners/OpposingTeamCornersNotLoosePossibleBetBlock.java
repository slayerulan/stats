package com.savik.blocks.football.match.corners;


import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.Period;
import com.savik.PossibleBetContainer;
import com.savik.bets.football.corners.PeriodOpposingTeamCornersNotLoosePossibleBet;
import com.savik.football.model.FootballMatch;

import java.util.function.Function;

public class OpposingTeamCornersNotLoosePossibleBetBlock extends PossibleBetContainer<FootballMatch> {
    public OpposingTeamCornersNotLoosePossibleBetBlock(MatchData homeMatchData, MatchData guestMatchData, Function<FootballMatch, Period> period) {
        super(
                new PeriodOpposingTeamCornersNotLoosePossibleBet(
                        homeMatchData, guestMatchData, period
                ), ContainerType.OPPOSING_TEAM_NOT_LOOSE
        );
    }
}
