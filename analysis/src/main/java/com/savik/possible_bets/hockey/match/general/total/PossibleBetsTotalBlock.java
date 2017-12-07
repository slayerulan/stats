package com.savik.possible_bets.hockey.match.general.total;


import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.PossibleBetContainer;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;

public class PossibleBetsTotalBlock extends PossibleBetContainer<HockeyMatch> {
    public PossibleBetsTotalBlock(MatchData homeMatchData, MatchData guestMatchData) {
        super(Arrays.asList(
                new PeriodTotalOverPossibleBetBlock(),
                new PeriodTotalUnderPossibleBetBlock(),
                new PeriodBothTeamTotalOverPossibleBetBlock(),
                new PeriodBothTeamTotalUnderPossibleBetBlock(),
                new PeriodTeamTotalOverPossibleBetBlock(homeMatchData, guestMatchData),
                new PeriodTeamTotalUnderPossibleBetBlock(homeMatchData, guestMatchData),
                new PeriodOpposingTeamTotalOverPossibleBetBlock(homeMatchData, guestMatchData),
                new PeriodOpposingTeamTotalUnderPossibleBetBlock(homeMatchData, guestMatchData)
        ), ContainerType.TOTAL);
    }
}
