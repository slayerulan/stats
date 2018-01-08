package com.savik.bets.football.cards;


import com.savik.Period;
import com.savik.PossibleBet;
import com.savik.blocks.football.cards.PeriodYellowCardsWDTotalOverSingleBlock;
import com.savik.blocks.football.cards.PeriodYellowCardsWDTotalUnderSingleBlock;
import com.savik.football.model.FootballMatch;

import java.util.function.Function;

public class PeriodYellowCardsWDTotalUnderPossibleBet extends PossibleBet<FootballMatch> {
    public PeriodYellowCardsWDTotalUnderPossibleBet(Function<FootballMatch, Period> function, double amount) {
        super(new PeriodYellowCardsWDTotalUnderSingleBlock(amount, function), new PeriodYellowCardsWDTotalUnderSingleBlock(amount, function));
    }
}
