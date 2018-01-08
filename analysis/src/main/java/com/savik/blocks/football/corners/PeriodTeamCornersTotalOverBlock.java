package com.savik.blocks.football.corners;

import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.Period;
import com.savik.PeriodTeamBetContainer;
import com.savik.bets.football.corners.PeriodGuestCornersTotalOver;
import com.savik.bets.football.corners.PeriodHomeCornersTotalOver;
import com.savik.football.model.FootballMatch;

import java.util.function.Function;


public class PeriodTeamCornersTotalOverBlock extends PeriodTeamBetContainer<FootballMatch> {

    public PeriodTeamCornersTotalOverBlock(double total, ContainerType type) {
        super(
                new PeriodHomeCornersTotalOver(total),
                new PeriodGuestCornersTotalOver(total),
                type
        );
    }

    public PeriodTeamCornersTotalOverBlock(double total, Function<FootballMatch, Period> function, MatchData matchData) {
        super(
                new PeriodHomeCornersTotalOver(total),
                new PeriodGuestCornersTotalOver(total),
                function, matchData
        );
    }


}
