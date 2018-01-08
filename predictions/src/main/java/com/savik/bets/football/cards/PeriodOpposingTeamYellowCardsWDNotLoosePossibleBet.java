package com.savik.bets.football.cards;


import com.savik.MatchData;
import com.savik.Period;
import com.savik.PossibleBet;
import com.savik.blocks.football.cards.PeriodOpposingTeamYellowCardsWDNotLooseSingleBlock;
import com.savik.blocks.football.cards.PeriodTeamYellowCardsWDNotLooseSingleBlock;
import com.savik.football.model.FootballMatch;

import java.util.function.Function;

public class PeriodOpposingTeamYellowCardsWDNotLoosePossibleBet extends PossibleBet<FootballMatch> {
    public PeriodOpposingTeamYellowCardsWDNotLoosePossibleBet(MatchData homeMatchData, MatchData guestMatchData,
                                                              Function<FootballMatch, Period> function) {
        super(
                new PeriodOpposingTeamYellowCardsWDNotLooseSingleBlock(function, homeMatchData),
                new PeriodTeamYellowCardsWDNotLooseSingleBlock(function, guestMatchData)
        );
    }
}
