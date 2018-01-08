package com.savik.bets.football.cards;


import com.savik.MatchData;
import com.savik.Period;
import com.savik.PossibleBet;
import com.savik.blocks.football.cards.PeriodOpposingTeamYellowCardsWDTotalOverSingleBlock;
import com.savik.blocks.football.cards.PeriodTeamYellowCardsWDTotalOverSingleBlock;
import com.savik.blocks.football.corners.PeriodOpposingTeamCornersTotalOverBlock;
import com.savik.football.model.FootballMatch;

import java.util.function.Function;

public class PeriodTeamYellowCardsWDTotalOverPossibleBet extends PossibleBet<FootballMatch> {
    public PeriodTeamYellowCardsWDTotalOverPossibleBet(MatchData homeMatchData, MatchData guestMatchData,
                                                       Function<FootballMatch, Period> function, double amount) {
        super(
                new PeriodTeamYellowCardsWDTotalOverSingleBlock(amount, function, homeMatchData),
                new PeriodOpposingTeamYellowCardsWDTotalOverSingleBlock(amount, function, guestMatchData)
        );
    }
}
