package com.savik.blocks.football.corners;

import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.Period;
import com.savik.PeriodTeamBetContainer;
import com.savik.bets.football.corners.PeriodGuestCornersHandicap;
import com.savik.bets.football.corners.PeriodHomeCornersHandicap;
import com.savik.football.model.FootballMatch;

import java.util.function.Function;


public class PeriodOpposingTeamCornersHandicapBlock extends PeriodTeamBetContainer<FootballMatch> {

    public PeriodOpposingTeamCornersHandicapBlock(double total, ContainerType type) {
        super(
                new PeriodGuestCornersHandicap(total),
                new PeriodHomeCornersHandicap(total),
                type
        );
    }

    public PeriodOpposingTeamCornersHandicapBlock(double total, Function<FootballMatch, Period> function, MatchData matchData) {
        super(
                new PeriodGuestCornersHandicap(total),
                new PeriodHomeCornersHandicap(total),
                function, matchData
        );
    }


}
