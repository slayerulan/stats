package com.savik.possible_bets.hockey.match.general.total;


import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.PossibleBetContainer;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;

public class PeriodOpposingTeamTotalOverPossibleBetBlock extends PossibleBetContainer<HockeyMatch> {
    public PeriodOpposingTeamTotalOverPossibleBetBlock(MatchData homeMatchData, MatchData guestMatchData) {
        super(
                Arrays.asList(
                        new PossibleBetContainer<>(
                                new PeriodOpposingTeamTotalOverPossibleBet(homeMatchData, guestMatchData, HockeyMatch.MATCH, 2.5),
                                ContainerType.OVER_2_5
                        ),
                        new PossibleBetContainer<>(
                                new PeriodOpposingTeamTotalOverPossibleBet(homeMatchData, guestMatchData, HockeyMatch.MATCH, 3.5),
                                ContainerType.OVER_3_5
                        )
                ), ContainerType.OPPOSING_TEAM_TOTAL_OVER
        );
    }
}
