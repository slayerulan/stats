package com.savik.blocks.football.match.cards.match;


import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.Period;
import com.savik.PossibleBetContainer;
import com.savik.bets.football.cards.PeriodOpposingTeamYellowCardsWDNotLoosePossibleBet;
import com.savik.football.model.FootballMatch;

import java.util.function.Function;

public class OpposingTeamYellowCardsWDNotLoosePossibleBetBlock extends PossibleBetContainer<FootballMatch> {
    public OpposingTeamYellowCardsWDNotLoosePossibleBetBlock(MatchData homeMatchData, MatchData guestMatchData, Function<FootballMatch, Period> period) {
        super(
                new PeriodOpposingTeamYellowCardsWDNotLoosePossibleBet(
                        homeMatchData, guestMatchData, period
                ), ContainerType.OPPOSING_TEAM_NOT_LOOSE
        );
    }
}
