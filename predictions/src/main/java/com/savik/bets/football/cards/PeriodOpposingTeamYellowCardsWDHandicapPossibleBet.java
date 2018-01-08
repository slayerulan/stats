package com.savik.bets.football.cards;


import com.savik.MatchData;
import com.savik.Period;
import com.savik.PossibleBet;
import com.savik.blocks.football.cards.PeriodOpposingTeamYellowCardsWDHandicapSingleBlock;
import com.savik.blocks.football.cards.PeriodTeamYellowCardsWDHandicapSingleBlock;
import com.savik.football.model.FootballMatch;

import java.util.function.Function;

public class PeriodOpposingTeamYellowCardsWDHandicapPossibleBet extends PossibleBet<FootballMatch> {
    public PeriodOpposingTeamYellowCardsWDHandicapPossibleBet(MatchData homeMatchData, MatchData guestMatchData,
                                                              Function<FootballMatch, Period> function, double amount) {
        super(
                new PeriodOpposingTeamYellowCardsWDHandicapSingleBlock(amount, function, homeMatchData),
                new PeriodTeamYellowCardsWDHandicapSingleBlock(amount, function, guestMatchData)
        );
    }
}
