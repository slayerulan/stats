package com.savik.blocks.hockey.match.general.other;


import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.PossibleBetContainer;
import com.savik.bets.general.other.PeriodOpposingTeamNotLooseAndTotalUnderPossibleBet;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;

class PeriodOpposingTeamNotLooseAndTotalUnderPossibleBetBlock extends PossibleBetContainer<HockeyMatch> {
    public PeriodOpposingTeamNotLooseAndTotalUnderPossibleBetBlock(MatchData homeMatchData, MatchData guestMatchData) {
        super(
                Arrays.asList(
                        new PossibleBetContainer<>(
                                new PeriodOpposingTeamNotLooseAndTotalUnderPossibleBet<>(homeMatchData, guestMatchData, HockeyMatch.MATCH, 4.5),
                                ContainerType.UNDER_4_5
                        ),
                        new PossibleBetContainer<>(
                                new PeriodOpposingTeamNotLooseAndTotalUnderPossibleBet<>(homeMatchData, guestMatchData, HockeyMatch.MATCH, 5.5),
                                ContainerType.UNDER_5_5
                        ),
                        new PossibleBetContainer<>(
                                new PeriodOpposingTeamNotLooseAndTotalUnderPossibleBet<>(homeMatchData, guestMatchData, HockeyMatch.MATCH, 6.5),
                                ContainerType.UNDER_6_5
                        )
                ), ContainerType.OPPOSING_TEAM_NOT_LOOSE_AND_TOTAL_UNDER
        );
    }
}
