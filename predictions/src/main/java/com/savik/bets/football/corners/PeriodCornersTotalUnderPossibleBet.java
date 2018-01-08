package com.savik.bets.football.corners;


import com.savik.Period;
import com.savik.PossibleBet;
import com.savik.blocks.football.corners.PeriodCornersTotalUnderSingleBlock;
import com.savik.football.model.FootballMatch;

import java.util.function.Function;

public class PeriodCornersTotalUnderPossibleBet extends PossibleBet<FootballMatch> {
    public PeriodCornersTotalUnderPossibleBet(Function<FootballMatch, Period> function, double amount) {
        super(new PeriodCornersTotalUnderSingleBlock(amount, function), new PeriodCornersTotalUnderSingleBlock(amount, function));
    }
}
