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


public class PeriodOpposingTeamOffsidesTotalOverBlock extends PeriodTeamBetContainer<FootballMatch> {

    public PeriodOpposingTeamOffsidesTotalOverBlock(double total, ContainerType type) {
        super(
                new PeriodGuestOffsidesTotalOver(total),
                new PeriodHomeOffsidesTotalOver(total),
                type
        );
    }

    public PeriodOpposingTeamOffsidesTotalOverBlock(double total, Function<FootballMatch, Period> function, MatchData matchData) {
        super(
                new PeriodGuestOffsidesTotalOver(total),
                new PeriodHomeOffsidesTotalOver(total),
                function, matchData
        );
    }


}