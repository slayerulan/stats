package com.savik.blocks.hockey.match.general.other;


import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.PossibleBetContainer;
import com.savik.bets.hockey.other.OpposingTeamScoredNInRowPossibleBet;
import com.savik.bets.hockey.other.TeamScoredNInRowPossibleBet;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;

class OpposingTeamScoredNInRowPossibleBetBlock extends PossibleBetContainer<HockeyMatch> {
    public OpposingTeamScoredNInRowPossibleBetBlock(MatchData homeMatchData, MatchData guestMatchData) {
        super(
                Arrays.asList(
                        new PossibleBetContainer<>(
                                new OpposingTeamScoredNInRowPossibleBet(2, homeMatchData, guestMatchData),
                                ContainerType.NUMBER_2
                        ),
                        new PossibleBetContainer<>(
                                new OpposingTeamScoredNInRowPossibleBet(3, homeMatchData, guestMatchData),
                                ContainerType.NUMBER_3
                        )

                ), ContainerType.OPPOSING_TEAM_SCORED_N_IN_ROW
        );
    }
}
