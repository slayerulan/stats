package com.savik.blocks.hockey.match.general.total;


import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.PossibleBetContainer;
import com.savik.bets.general.total.PeriodTeamTotalUnderPossibleBet;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;

public class PeriodTeamTotalUnderPossibleBetBlock extends PossibleBetContainer<HockeyMatch> {
    public PeriodTeamTotalUnderPossibleBetBlock(MatchData homeMatchData, MatchData guestMatchData) {
        super(
                Arrays.asList(
                        new PossibleBetContainer<>(
                                new PeriodTeamTotalUnderPossibleBet(homeMatchData, guestMatchData, HockeyMatch.MATCH, 2.5),
                                ContainerType.UNDER_2_5
                        ),
                        new PossibleBetContainer<>(
                                new PeriodTeamTotalUnderPossibleBet(homeMatchData, guestMatchData, HockeyMatch.MATCH, 3.5),
                                ContainerType.UNDER_3_5
                        )
                ), ContainerType.TEAM_TOTAL_UNDER
        );
    }
}
