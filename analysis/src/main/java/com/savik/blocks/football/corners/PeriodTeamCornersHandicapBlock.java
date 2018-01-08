package com.savik.blocks.football.corners;

import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.Period;
import com.savik.PeriodTeamBetContainer;
import com.savik.bets.football.corners.PeriodGuestCornersHandicap;
import com.savik.bets.football.corners.PeriodGuestCornersTotalOver;
import com.savik.bets.football.corners.PeriodHomeCornersHandicap;
import com.savik.bets.football.corners.PeriodHomeCornersTotalOver;
import com.savik.football.model.FootballMatch;

import java.util.function.Function;


public class PeriodTeamCornersHandicapBlock extends PeriodTeamBetContainer<FootballMatch> {

    public PeriodTeamCornersHandicapBlock(double total, ContainerType type) {
        super(
                new PeriodHomeCornersHandicap(total),
                new PeriodGuestCornersHandicap(total),
                type
        );
    }

    public PeriodTeamCornersHandicapBlock(double total, Function<FootballMatch, Period> function, MatchData matchData) {
        super(
                new PeriodHomeCornersHandicap(total),
                new PeriodGuestCornersHandicap(total),
                function, matchData
        );
    }


}
