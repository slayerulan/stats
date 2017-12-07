package com.savik.possible_bets.hockey.match.general.other;


import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.PossibleBetContainer;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;

public class PossibleBetsOtherBlock extends PossibleBetContainer<HockeyMatch> {
    public PossibleBetsOtherBlock(MatchData homeMatchData, MatchData guestMatchData) {
        super(Arrays.asList(
                new PeriodAnyWinAndDiffEqualsPossibleBetBlock(),
                new PeriodAnyWinAndTotalOverPossibleBetBlock(),
                new PeriodAnyWinAndTotalUnderPossibleBetBlock(),
                new PeriodTeamWinAndTotalOverPossibleBetBlock(homeMatchData, guestMatchData),
                new PeriodTeamWinAndTotalUnderPossibleBetBlock(homeMatchData, guestMatchData)
        ), ContainerType.OTHER);
    }
}
