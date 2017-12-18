package com.savik.blocks.hockey.match.general.total;


import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.PossibleBetContainer;
import com.savik.bets.general.total.PeriodOpposingTeamTotalUnderPossibleBet;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;

public class PeriodOpposingTeamTotalUnderPossibleBetBlock extends PossibleBetContainer<HockeyMatch> {
    public PeriodOpposingTeamTotalUnderPossibleBetBlock(MatchData homeMatchData, MatchData guestMatchData) {
        super(
                Arrays.asList(
                        new PossibleBetContainer<>(
                                new PeriodOpposingTeamTotalUnderPossibleBet<>(homeMatchData, guestMatchData, HockeyMatch.MATCH, 1.5),
                                ContainerType.UNDER_1_5
                        ),
                        new PossibleBetContainer<>(
                                new PeriodOpposingTeamTotalUnderPossibleBet<>(homeMatchData, guestMatchData, HockeyMatch.MATCH, 2.5),
                                ContainerType.UNDER_2_5
                        ),
                        new PossibleBetContainer<>(
                                new PeriodOpposingTeamTotalUnderPossibleBet<>(homeMatchData, guestMatchData, HockeyMatch.MATCH, 3.5),
                                ContainerType.UNDER_3_5
                        )
                ), ContainerType.OPPOSING_TEAM_TOTAL_UNDER
        );
    }
}
