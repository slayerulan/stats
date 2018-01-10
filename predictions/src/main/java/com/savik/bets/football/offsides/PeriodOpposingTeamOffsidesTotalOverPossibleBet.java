package com.savik.bets.football.offsides;


import com.savik.MatchData;
import com.savik.Period;
import com.savik.PossibleBet;
import com.savik.blocks.football.offsides.PeriodOpposingTeamOffsidesTotalOverBlock;
import com.savik.blocks.football.offsides.PeriodTeamOffsidesTotalOverBlock;
import com.savik.football.model.FootballMatch;

import java.util.function.Function;

public class PeriodOpposingTeamOffsidesTotalOverPossibleBet extends PossibleBet<FootballMatch> {
    public PeriodOpposingTeamOffsidesTotalOverPossibleBet(MatchData homeMatchData, MatchData guestMatchData,
                                                         Function<FootballMatch, Period> function, double amount) {
        super(
                new PeriodOpposingTeamOffsidesTotalOverBlock(amount, function, homeMatchData),
                new PeriodTeamOffsidesTotalOverBlock(amount, function, guestMatchData)
        );
    }
}
