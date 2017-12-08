package com.savik.blocks.hockey.match.general.other;


import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.PossibleBetContainer;
import com.savik.bets.general.other.PeriodOpposingTeamWinAndTotalOverPossibleBet;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;

class PeriodOpposingTeamWinAndTotalOverPossibleBetBlock extends PossibleBetContainer<HockeyMatch> {
    public PeriodOpposingTeamWinAndTotalOverPossibleBetBlock(MatchData homeMatchData, MatchData guestMatchData) {
        super(
                Arrays.asList(
                        new PossibleBetContainer<>(
                                new PeriodOpposingTeamWinAndTotalOverPossibleBet(homeMatchData, guestMatchData, HockeyMatch.MATCH, 4.5),
                                ContainerType.OVER_4_5
                        ),
                        new PossibleBetContainer<>(
                                new PeriodOpposingTeamWinAndTotalOverPossibleBet(homeMatchData, guestMatchData, HockeyMatch.MATCH, 5.5),
                                ContainerType.OVER_5_5
                        )
                ), ContainerType.OPPOSING_TEAM_WIN_AND_TOTAL_OVER
        );
    }
}
