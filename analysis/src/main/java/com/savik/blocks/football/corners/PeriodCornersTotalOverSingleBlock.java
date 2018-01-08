package com.savik.blocks.football.corners;

import com.savik.ContainerType;
import com.savik.Period;
import com.savik.PeriodBetContainer;
import com.savik.bets.football.corners.PeriodCornersTotalOver;
import com.savik.football.model.FootballMatch;

import java.util.function.Function;


public class PeriodCornersTotalOverSingleBlock extends PeriodBetContainer<FootballMatch> {

    public PeriodCornersTotalOverSingleBlock(double amount, ContainerType type) {
        super(new PeriodCornersTotalOver(amount), type);
    }

    public PeriodCornersTotalOverSingleBlock(double amount, Function<FootballMatch, Period> function) {
        super(new PeriodCornersTotalOver(amount), function);
    }


}
