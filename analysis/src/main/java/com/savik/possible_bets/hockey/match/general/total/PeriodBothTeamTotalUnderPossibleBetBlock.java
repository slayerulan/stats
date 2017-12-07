package com.savik.possible_bets.hockey.match.general.total;


import com.savik.ContainerType;
import com.savik.PossibleBetContainer;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;

public class PeriodBothTeamTotalUnderPossibleBetBlock extends PossibleBetContainer<HockeyMatch> {
    public PeriodBothTeamTotalUnderPossibleBetBlock() {
        super(Arrays.asList(
                new PossibleBetContainer<>(
                        new PeriodBothTeamTotalUnderPossibleBet(HockeyMatch.MATCH, 2.5),
                        ContainerType.UNDER_2_5
                ),
                new PossibleBetContainer<>(
                        new PeriodBothTeamTotalUnderPossibleBet(HockeyMatch.MATCH, 3.5),
                        ContainerType.UNDER_3_5
                )
                ), ContainerType.BOTH_TEAMS_TOTAL_UNDER
        );
    }
}
