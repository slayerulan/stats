package com.savik.bets.football.offsides;


import com.savik.Period;
import com.savik.PossibleBet;
import com.savik.blocks.football.offsides.PeriodOffsidesTotalUnderSingleBlock;
import com.savik.football.model.FootballMatch;

import java.util.function.Function;

public class PeriodOffsidesTotalUnderPossibleBet extends PossibleBet<FootballMatch> {
    public PeriodOffsidesTotalUnderPossibleBet(Function<FootballMatch, Period> function, double amount) {
        super(new PeriodOffsidesTotalUnderSingleBlock(amount, function), new PeriodOffsidesTotalUnderSingleBlock(amount, function));
    }
}
