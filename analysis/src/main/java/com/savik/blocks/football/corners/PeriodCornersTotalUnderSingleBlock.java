package com.savik.blocks.football.corners;

import com.savik.ContainerType;
import com.savik.Period;
import com.savik.PeriodBetContainer;
import com.savik.bets.football.corners.PeriodCornersTotalUnder;
import com.savik.football.model.FootballMatch;

import java.util.function.Function;


public class PeriodCornersTotalUnderSingleBlock extends PeriodBetContainer<FootballMatch> {

    public PeriodCornersTotalUnderSingleBlock(double amount, ContainerType type) {
        super(new PeriodCornersTotalUnder(amount), type);
    }

    public PeriodCornersTotalUnderSingleBlock(double amount, Function<FootballMatch, Period> function) {
        super(new PeriodCornersTotalUnder(amount), function);
    }


}
