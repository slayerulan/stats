package com.savik.blocks.football.offsides;

import com.savik.ContainerType;
import com.savik.Period;
import com.savik.PeriodBetContainer;
import com.savik.bets.football.corners.PeriodCornersTotalOver;
import com.savik.bets.football.offsides.PeriodOffsidesTotalOver;
import com.savik.football.model.FootballMatch;

import java.util.function.Function;


public class PeriodOffsidesTotalOverSingleBlock extends PeriodBetContainer<FootballMatch> {

    public PeriodOffsidesTotalOverSingleBlock(double amount, ContainerType type) {
        super(new PeriodOffsidesTotalOver(amount), type);
    }

    public PeriodOffsidesTotalOverSingleBlock(double amount, Function<FootballMatch, Period> function) {
        super(new PeriodOffsidesTotalOver(amount), function);
    }


}
