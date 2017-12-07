package com.savik.possible_bets.hockey.match.general.other;


import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.PossibleBetContainer;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;

public class PossibleBetsOtherBlock extends PossibleBetContainer<HockeyMatch> {
    public PossibleBetsOtherBlock(MatchData homeMatchData, MatchData guestMatchData) {
        super(Arrays.asList(
                new PeriodAnyWinAndDiffEqualsPossibleBetBlock(HockeyMatch.MATCH, 1, ContainerType.DIFF_1),
                new PeriodAnyWinAndDiffEqualsPossibleBetBlock(HockeyMatch.MATCH, 2, ContainerType.DIFF_2),
                new PeriodAnyWinAndTotalOverPossibleBetBlock(HockeyMatch.MATCH, 5.5, ContainerType.ANY_WIN_AND_TOTAL_OVER),
                new PeriodAnyWinAndTotalUnderPossibleBetBlock(HockeyMatch.MATCH, 5.5, ContainerType.ANY_WIN_AND_TOTAL_UNDER)
        ), ContainerType.OTHER);
    }
}
