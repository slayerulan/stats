package com.savik.blocks.hockey.match.general.other;


import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.PossibleBetContainer;
import com.savik.bets.general.other.PeriodTeamWinAndTotalUnderPossibleBet;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;

class PeriodTeamWinAndTotalUnderPossibleBetBlock extends PossibleBetContainer<HockeyMatch> {
    public PeriodTeamWinAndTotalUnderPossibleBetBlock(MatchData homeMatchData, MatchData guestMatchData) {
        super(
                Arrays.asList(
                        new PossibleBetContainer<>(
                                new PeriodTeamWinAndTotalUnderPossibleBet(homeMatchData, guestMatchData, HockeyMatch.MATCH, 4.5),
                                ContainerType.UNDER_4_5
                        ),
                        new PossibleBetContainer<>(
                                new PeriodTeamWinAndTotalUnderPossibleBet(homeMatchData, guestMatchData, HockeyMatch.MATCH, 5.5),
                                ContainerType.UNDER_5_5
                        )
                ), ContainerType.TEAM_WIN_AND_TOTAL_UNDER
        );
    }
}
