package com.savik.bets.football.corners;


import com.savik.Period;
import com.savik.PossibleBet;
import com.savik.blocks.football.corners.PeriodCornersTotalOverSingleBlock;
import com.savik.football.model.FootballMatch;

import java.util.function.Function;

public class PeriodCornersTotalOverPossibleBet extends PossibleBet<FootballMatch> {
    public PeriodCornersTotalOverPossibleBet(Function<FootballMatch, Period> function, double amount) {
        super(new PeriodCornersTotalOverSingleBlock(amount, function), new PeriodCornersTotalOverSingleBlock(amount, function));
    }
}
