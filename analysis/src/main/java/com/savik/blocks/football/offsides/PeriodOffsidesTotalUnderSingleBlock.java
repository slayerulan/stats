package com.savik.blocks.football.offsides;

import com.savik.ContainerType;
import com.savik.Period;
import com.savik.PeriodBetContainer;
import com.savik.bets.football.corners.PeriodCornersTotalUnder;
import com.savik.bets.football.offsides.PeriodOffsidesTotalUnder;
import com.savik.football.model.FootballMatch;

import java.util.function.Function;


public class PeriodOffsidesTotalUnderSingleBlock extends PeriodBetContainer<FootballMatch> {

    public PeriodOffsidesTotalUnderSingleBlock(double amount, ContainerType type) {
        super(new PeriodOffsidesTotalUnder(amount), type);
    }

    public PeriodOffsidesTotalUnderSingleBlock(double amount, Function<FootballMatch, Period> function) {
        super(new PeriodOffsidesTotalUnder(amount), function);
    }


}
