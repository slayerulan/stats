package com.savik.blocks.football.match.cards.match;


import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.PossibleBetContainer;
import com.savik.bets.football.cards.PeriodTeamYellowCardsWDNotLoosePossibleBet;
import com.savik.football.model.FootballMatch;

public class TeamYellowCardsWDNotLoosePossibleBetBlock extends PossibleBetContainer<FootballMatch> {
    public TeamYellowCardsWDNotLoosePossibleBetBlock(MatchData homeMatchData, MatchData guestMatchData) {
        super(
                new PeriodTeamYellowCardsWDNotLoosePossibleBet(
                        homeMatchData, guestMatchData, FootballMatch.MATCH
                ), ContainerType.TEAM_NOT_LOOSE
        );
    }
}
