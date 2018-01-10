package com.savik.blocks.football.offsides;

import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.Period;
import com.savik.PeriodTeamBetContainer;
import com.savik.bets.football.corners.PeriodGuestCornersHandicap;
import com.savik.bets.football.corners.PeriodHomeCornersHandicap;
import com.savik.bets.football.offsides.PeriodGuestOffsidesHandicap;
import com.savik.bets.football.offsides.PeriodHomeOffsidesHandicap;
import com.savik.football.model.FootballMatch;

import java.util.function.Function;


public class PeriodTeamOffsidesHandicapBlock extends PeriodTeamBetContainer<FootballMatch> {

    public PeriodTeamOffsidesHandicapBlock(double total, ContainerType type) {
        super(
                new PeriodHomeOffsidesHandicap(total),
                new PeriodGuestOffsidesHandicap(total),
                type
        );
    }

    public PeriodTeamOffsidesHandicapBlock(double total, Function<FootballMatch, Period> function, MatchData matchData) {
        super(
                new PeriodHomeOffsidesHandicap(total),
                new PeriodGuestOffsidesHandicap(total),
                function, matchData
        );
    }


}
