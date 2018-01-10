package com.savik.bets.football.offsides;


import com.savik.Period;
import com.savik.PossibleBet;
import com.savik.blocks.football.offsides.PeriodOffsidesTotalOverSingleBlock;
import com.savik.football.model.FootballMatch;

import java.util.function.Function;

public class PeriodOffsidesTotalOverPossibleBet extends PossibleBet<FootballMatch> {
    public PeriodOffsidesTotalOverPossibleBet(Function<FootballMatch, Period> function, double amount) {
        super(new PeriodOffsidesTotalOverSingleBlock(amount, function), new PeriodOffsidesTotalOverSingleBlock(amount, function));
    }
}
