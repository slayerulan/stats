package com.savik.blocks.football.cards;

import com.savik.ContainerType;
import com.savik.Period;
import com.savik.PeriodBetContainer;
import com.savik.bets.football.cards.PeriodYellowCardsWDTotalOver;
import com.savik.bets.football.cards.PeriodYellowCardsWDTotalUnder;
import com.savik.football.model.FootballMatch;

import java.util.function.Function;


public class PeriodYellowCardsWDTotalUnderSingleBlock extends PeriodBetContainer<FootballMatch> {

    public PeriodYellowCardsWDTotalUnderSingleBlock(double amount, ContainerType type) {
        super(new PeriodYellowCardsWDTotalUnder(amount), type);
    }

    public PeriodYellowCardsWDTotalUnderSingleBlock(double amount, Function<FootballMatch, Period> function) {
        super(new PeriodYellowCardsWDTotalUnder(amount), function);
    }


}
