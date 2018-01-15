package com.savik.blocks.football.match.corners;


import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.Period;
import com.savik.PossibleBetContainer;
import com.savik.bets.football.corners.PeriodTeamCornersNotLoosePossibleBet;
import com.savik.football.model.FootballMatch;

import java.util.function.Function;

public class TeamCornersNotLoosePossibleBetBlock extends PossibleBetContainer<FootballMatch> {
    public TeamCornersNotLoosePossibleBetBlock(MatchData homeMatchData, MatchData guestMatchData, Function<FootballMatch, Period> period) {
        super(
                new PeriodTeamCornersNotLoosePossibleBet(
                        homeMatchData, guestMatchData, period
                ), ContainerType.TEAM_NOT_LOOSE
        );
    }
}
