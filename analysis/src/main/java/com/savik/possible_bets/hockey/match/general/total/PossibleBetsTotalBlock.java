package com.savik.possible_bets.hockey.match.general.total;


import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.PossibleBetContainer;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;

public class PossibleBetsTotalBlock extends PossibleBetContainer<HockeyMatch> {
    public PossibleBetsTotalBlock(MatchData homeMatchData, MatchData guestMatchData) {
        super(Arrays.asList(
                new PeriodTotalOverPossibleBetBlock(HockeyMatch.MATCH, 4.5, ContainerType.OVER_4_5),
                new PeriodTotalOverPossibleBetBlock(HockeyMatch.MATCH, 5.5, ContainerType.OVER_5_5),
                new PeriodAnyWinAndDiffEqualsPossibleBetBlock(HockeyMatch.MATCH, 1, ContainerType.DIFF_1),
                new PeriodAnyWinAndDiffEqualsPossibleBetBlock(HockeyMatch.MATCH, 2, ContainerType.DIFF_2),
                new PeriodTeamTotalOverPossibleBetBlock(homeMatchData, guestMatchData, HockeyMatch.MATCH, 2.5, ContainerType.OVER_2_5),
                new PeriodTeamTotalOverPossibleBetBlock(homeMatchData, guestMatchData, HockeyMatch.MATCH, 3.5, ContainerType.OVER_3_5)
        ), ContainerType.TOTAL);
    }
}
