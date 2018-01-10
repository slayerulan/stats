package com.savik.blocks.football.offsides;

import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.Period;
import com.savik.PeriodTeamBetContainer;
import com.savik.bets.football.corners.PeriodGuestCornersTotalOver;
import com.savik.bets.football.corners.PeriodHomeCornersTotalOver;
import com.savik.bets.football.offsides.PeriodGuestOffsidesTotalOver;
import com.savik.bets.football.offsides.PeriodHomeOffsidesTotalOver;
import com.savik.football.model.FootballMatch;

import java.util.function.Function;


public class PeriodTeamOffsidesTotalOverBlock extends PeriodTeamBetContainer<FootballMatch> {

    public PeriodTeamOffsidesTotalOverBlock(double total, ContainerType type) {
        super(
                new PeriodHomeOffsidesTotalOver(total),
                new PeriodGuestOffsidesTotalOver(total),
                type
        );
    }

    public PeriodTeamOffsidesTotalOverBlock(double total, Function<FootballMatch, Period> function, MatchData matchData) {
        super(
                new PeriodHomeOffsidesTotalOver(total),
                new PeriodGuestOffsidesTotalOver(total),
                function, matchData
        );
    }


}
