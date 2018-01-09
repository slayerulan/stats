package com.savik.blocks.football.match.cards.match;


import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.PossibleBetContainer;
import com.savik.bets.football.cards.PeriodOpposingTeamYellowCardsWDNotLoosePossibleBet;
import com.savik.football.model.FootballMatch;

public class OpposingTeamYellowCardsWDNotLoosePossibleBetBlock extends PossibleBetContainer<FootballMatch> {
    public OpposingTeamYellowCardsWDNotLoosePossibleBetBlock(MatchData homeMatchData, MatchData guestMatchData) {
        super(
                new PeriodOpposingTeamYellowCardsWDNotLoosePossibleBet(
                        homeMatchData, guestMatchData, FootballMatch.MATCH
                ), ContainerType.OPPOSING_TEAM_NOT_LOOSE
        );
    }
}
