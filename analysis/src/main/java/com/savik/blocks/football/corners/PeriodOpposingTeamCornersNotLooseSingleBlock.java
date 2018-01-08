package com.savik.blocks.football.corners;

import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.Period;
import com.savik.PeriodTeamBetContainer;
import com.savik.bets.football.corners.PeriodGuestCornersNotLoose;
import com.savik.bets.football.corners.PeriodHomeCornersNotLoose;
import com.savik.football.model.FootballMatch;

import java.util.function.Function;


public class PeriodOpposingTeamCornersNotLooseSingleBlock extends PeriodTeamBetContainer<FootballMatch> {

    public PeriodOpposingTeamCornersNotLooseSingleBlock(ContainerType type) {
        super(
                new PeriodGuestCornersNotLoose(),
                new PeriodHomeCornersNotLoose(),
                type
        );
    }

    public PeriodOpposingTeamCornersNotLooseSingleBlock(Function<FootballMatch, Period> function, MatchData matchData) {
        super(
                new PeriodGuestCornersNotLoose(),
                new PeriodHomeCornersNotLoose(),
                function, matchData
        );
    }


}
