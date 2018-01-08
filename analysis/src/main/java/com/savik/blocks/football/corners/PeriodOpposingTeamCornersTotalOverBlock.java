package com.savik.blocks.football.corners;

import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.Period;
import com.savik.PeriodTeamBetContainer;
import com.savik.football.model.FootballMatch;

import java.util.function.Function;


public class PeriodOpposingTeamCornersTotalOverBlock extends PeriodTeamBetContainer<FootballMatch> {

    public PeriodOpposingTeamCornersTotalOverBlock(double total, ContainerType type) {
        super(
                new PeriodGuestCornersTotalOver(total),
                new PeriodHomeCornersTotalOver(total),
                type
        );
    }

    public PeriodOpposingTeamCornersTotalOverBlock(double total, Function<FootballMatch, Period> function, MatchData matchData) {
        super(
                new PeriodGuestCornersTotalOver(total),
                new PeriodHomeCornersTotalOver(total),
                function, matchData
        );
    }


}
