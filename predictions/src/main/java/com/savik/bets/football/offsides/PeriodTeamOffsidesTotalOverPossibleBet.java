package com.savik.bets.football.offsides;


import com.savik.MatchData;
import com.savik.Period;
import com.savik.PossibleBet;
import com.savik.blocks.football.offsides.PeriodOpposingTeamOffsidesTotalOverBlock;
import com.savik.blocks.football.offsides.PeriodTeamOffsidesTotalOverBlock;
import com.savik.football.model.FootballMatch;

import java.util.function.Function;

public class PeriodTeamOffsidesTotalOverPossibleBet extends PossibleBet<FootballMatch> {
    public PeriodTeamOffsidesTotalOverPossibleBet(MatchData homeMatchData, MatchData guestMatchData,
                                                 Function<FootballMatch, Period> function, double amount) {
        super(
                new PeriodTeamOffsidesTotalOverBlock(amount, function, homeMatchData),
                new PeriodOpposingTeamOffsidesTotalOverBlock(amount, function, guestMatchData)
        );
    }
}
