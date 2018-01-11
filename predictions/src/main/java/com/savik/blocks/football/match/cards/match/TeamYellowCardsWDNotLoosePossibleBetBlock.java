package com.savik.blocks.football.match.cards.match;


import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.Period;
import com.savik.PossibleBetContainer;
import com.savik.bets.football.cards.PeriodTeamYellowCardsWDNotLoosePossibleBet;
import com.savik.football.model.FootballMatch;

import java.util.function.Function;

public class TeamYellowCardsWDNotLoosePossibleBetBlock extends PossibleBetContainer<FootballMatch> {
    public TeamYellowCardsWDNotLoosePossibleBetBlock(MatchData homeMatchData, MatchData guestMatchData, Function<FootballMatch, Period> period) {
        super(
                new PeriodTeamYellowCardsWDNotLoosePossibleBet(
                        homeMatchData, guestMatchData, period
                ), ContainerType.TEAM_NOT_LOOSE
        );
    }
}
