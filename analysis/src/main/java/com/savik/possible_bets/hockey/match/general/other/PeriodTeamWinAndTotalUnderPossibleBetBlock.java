package com.savik.possible_bets.hockey.match.general.other;


import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.Period;
import com.savik.PossibleBetContainer;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;
import java.util.function.Function;

class PeriodTeamWinAndTotalUnderPossibleBetBlock extends PossibleBetContainer<HockeyMatch> {
    public PeriodTeamWinAndTotalUnderPossibleBetBlock(MatchData homeMatchData, MatchData guestMatchData) {
        super(
                Arrays.asList(
                        new PossibleBetContainer<>(
                                new PeriodTeamWinAndTotalUnderPossibleBet(homeMatchData, guestMatchData, HockeyMatch.MATCH, 5.5),
                                ContainerType.OVER_5_5
                        )
                ), ContainerType.TEAM_WIN_AND_TOTAL_UNDER
        );
    }
}
