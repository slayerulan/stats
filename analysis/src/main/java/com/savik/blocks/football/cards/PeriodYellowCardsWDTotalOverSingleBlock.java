package com.savik.blocks.football.cards;

import com.savik.ContainerType;
import com.savik.Period;
import com.savik.PeriodBetContainer;
import com.savik.bets.football.cards.PeriodYellowCardsWDTotalOver;
import com.savik.bets.football.corners.PeriodCornersTotalOver;
import com.savik.football.model.FootballMatch;

import java.util.function.Function;


public class PeriodYellowCardsWDTotalOverSingleBlock extends PeriodBetContainer<FootballMatch> {

    public PeriodYellowCardsWDTotalOverSingleBlock(double amount, ContainerType type) {
        super(new PeriodYellowCardsWDTotalOver(amount), type);
    }

    public PeriodYellowCardsWDTotalOverSingleBlock(double amount, Function<FootballMatch, Period> function) {
        super(new PeriodYellowCardsWDTotalOver(amount), function);
    }


}
