package com.savik.blocks.football.offsides;

import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.Period;
import com.savik.PeriodTeamBetContainer;
import com.savik.bets.football.corners.PeriodGuestCornersNotLoose;
import com.savik.bets.football.corners.PeriodHomeCornersNotLoose;
import com.savik.bets.football.offsides.PeriodGuestOffsidesNotLoose;
import com.savik.bets.football.offsides.PeriodHomeOffsidesNotLoose;
import com.savik.football.model.FootballMatch;

import java.util.function.Function;


public class PeriodOpposingTeamOffsidesNotLooseSingleBlock extends PeriodTeamBetContainer<FootballMatch> {

    public PeriodOpposingTeamOffsidesNotLooseSingleBlock(ContainerType type) {
        super(
                new PeriodGuestOffsidesNotLoose(),
                new PeriodHomeOffsidesNotLoose(),
                type
        );
    }

    public PeriodOpposingTeamOffsidesNotLooseSingleBlock(Function<FootballMatch, Period> function, MatchData matchData) {
        super(
                new PeriodGuestOffsidesNotLoose(),
                new PeriodHomeOffsidesNotLoose(),
                function, matchData
        );
    }


}
