package com.savik.possible_bets.hockey.match.general.other;


import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.PossibleBetContainer;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;

class PeriodTeamNotLooseAndTotalOverPossibleBetBlock extends PossibleBetContainer<HockeyMatch> {
    public PeriodTeamNotLooseAndTotalOverPossibleBetBlock(MatchData homeMatchData, MatchData guestMatchData) {
        super(
                Arrays.asList(
                        new PossibleBetContainer<>(
                                new PeriodTeamNotLooseAndTotalOverPossibleBet(homeMatchData, guestMatchData, HockeyMatch.MATCH, 4.5),
                                ContainerType.OVER_4_5
                        ),
                        new PossibleBetContainer<>(
                                new PeriodTeamNotLooseAndTotalOverPossibleBet(homeMatchData, guestMatchData, HockeyMatch.MATCH, 5.5),
                                ContainerType.OVER_5_5
                        )
                ), ContainerType.TEAM_NOT_LOOSE_AND_TOTAL_OVER
        );
    }
}
