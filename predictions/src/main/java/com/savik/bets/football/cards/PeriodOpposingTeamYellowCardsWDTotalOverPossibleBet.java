package com.savik.bets.football.cards;


import com.savik.MatchData;
import com.savik.Period;
import com.savik.PossibleBet;
import com.savik.blocks.football.cards.PeriodOpposingTeamYellowCardsWDTotalOverSingleBlock;
import com.savik.blocks.football.cards.PeriodTeamYellowCardsWDTotalOverSingleBlock;
import com.savik.football.model.FootballMatch;

import java.util.function.Function;

public class PeriodOpposingTeamYellowCardsWDTotalOverPossibleBet extends PossibleBet<FootballMatch> {
    public PeriodOpposingTeamYellowCardsWDTotalOverPossibleBet(MatchData homeMatchData, MatchData guestMatchData,
                                                               Function<FootballMatch, Period> function, double amount) {
        super(
                new PeriodOpposingTeamYellowCardsWDTotalOverSingleBlock(amount, function, homeMatchData),
                new PeriodTeamYellowCardsWDTotalOverSingleBlock(amount, function, guestMatchData)
        );
    }
}
