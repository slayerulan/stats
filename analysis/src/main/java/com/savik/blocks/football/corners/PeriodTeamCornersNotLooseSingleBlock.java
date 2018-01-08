package com.savik.blocks.football.corners;

import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.Period;
import com.savik.PeriodTeamBetContainer;
import com.savik.bets.football.corners.PeriodGuestCornersNotLoose;
import com.savik.bets.football.corners.PeriodHomeCornersNotLoose;
import com.savik.football.model.FootballMatch;

import java.util.function.Function;


public class PeriodTeamCornersNotLooseSingleBlock extends PeriodTeamBetContainer<FootballMatch> {

    public PeriodTeamCornersNotLooseSingleBlock(ContainerType type) {
        super(
                new PeriodHomeCornersNotLoose(),
                new PeriodGuestCornersNotLoose(),
                type
        );
    }

    public PeriodTeamCornersNotLooseSingleBlock(Function<FootballMatch, Period> function, MatchData matchData) {
        super(
                new PeriodHomeCornersNotLoose(),
                new PeriodGuestCornersNotLoose(),
                function, matchData
        );
    }


}
