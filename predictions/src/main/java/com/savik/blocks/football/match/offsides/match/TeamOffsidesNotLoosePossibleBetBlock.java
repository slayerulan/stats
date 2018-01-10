package com.savik.blocks.football.match.offsides.match;


import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.PossibleBetContainer;
import com.savik.bets.football.offsides.PeriodTeamOffsidesNotLoosePossibleBet;
import com.savik.football.model.FootballMatch;

public class TeamOffsidesNotLoosePossibleBetBlock extends PossibleBetContainer<FootballMatch> {
    public TeamOffsidesNotLoosePossibleBetBlock(MatchData homeMatchData, MatchData guestMatchData) {
        super(
                new PeriodTeamOffsidesNotLoosePossibleBet(
                        homeMatchData, guestMatchData, FootballMatch.MATCH
                ), ContainerType.TEAM_NOT_LOOSE
        );
    }
}
