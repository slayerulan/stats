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


public class PeriodTeamOffsidesNotLooseSingleBlock extends PeriodTeamBetContainer<FootballMatch> {

    public PeriodTeamOffsidesNotLooseSingleBlock(ContainerType type) {
        super(
                new PeriodHomeOffsidesNotLoose(),
                new PeriodGuestOffsidesNotLoose(),
                type
        );
    }

    public PeriodTeamOffsidesNotLooseSingleBlock(Function<FootballMatch, Period> function, MatchData matchData) {
        super(
                new PeriodHomeOffsidesNotLoose(),
                new PeriodGuestOffsidesNotLoose(),
                function, matchData
        );
    }


}
