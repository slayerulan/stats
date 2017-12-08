package com.savik.possible_bets.hockey.match.general.other;


import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.PossibleBetContainer;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;

class PeriodOpposingTeamNotLooseAndTotalOverPossibleBetBlock extends PossibleBetContainer<HockeyMatch> {
    public PeriodOpposingTeamNotLooseAndTotalOverPossibleBetBlock(MatchData homeMatchData, MatchData guestMatchData) {
        super(
                Arrays.asList(
                        new PossibleBetContainer<>(
                                new PeriodOpposingTeamNotLooseAndTotalOverPossibleBet(homeMatchData, guestMatchData, HockeyMatch.MATCH, 5.5),
                                ContainerType.OVER_5_5
                        )
                ), ContainerType.OPPOSING_TEAM_NOT_LOOSE_AND_TOTAL_OVER
        );
    }
}
