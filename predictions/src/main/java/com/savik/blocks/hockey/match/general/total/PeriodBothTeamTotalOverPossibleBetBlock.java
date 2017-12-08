package com.savik.blocks.hockey.match.general.total;


import com.savik.ContainerType;
import com.savik.PossibleBetContainer;
import com.savik.bets.general.total.PeriodBothTeamTotalOverPossibleBet;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;

public class PeriodBothTeamTotalOverPossibleBetBlock extends PossibleBetContainer<HockeyMatch> {
    public PeriodBothTeamTotalOverPossibleBetBlock() {
        super(Arrays.asList(
                new PossibleBetContainer<>(
                        new PeriodBothTeamTotalOverPossibleBet(HockeyMatch.MATCH, 1.5),
                        ContainerType.OVER_1_5
                ),
                new PossibleBetContainer<>(
                        new PeriodBothTeamTotalOverPossibleBet(HockeyMatch.MATCH, 2.5),
                        ContainerType.OVER_2_5
                )
                ), ContainerType.BOTH_TEAMS_TOTAL_OVER
        );
    }
}
