package com.savik.bets.football.cards;


import com.savik.Period;
import com.savik.PossibleBet;
import com.savik.blocks.football.cards.PeriodYellowCardsWDTotalOverSingleBlock;
import com.savik.blocks.football.corners.PeriodCornersTotalOverSingleBlock;
import com.savik.football.model.FootballMatch;

import java.util.function.Function;

public class PeriodYellowCardsWDTotalOverPossibleBet extends PossibleBet<FootballMatch> {
    public PeriodYellowCardsWDTotalOverPossibleBet(Function<FootballMatch, Period> function, double amount) {
        super(new PeriodYellowCardsWDTotalOverSingleBlock(amount, function), new PeriodYellowCardsWDTotalOverSingleBlock(amount, function));
    }
}
