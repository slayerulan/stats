package com.savik.possible_bets.hockey.match.general.handicap;


import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.PossibleBetContainer;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;

public class PossibleBetsHandicapBlock extends PossibleBetContainer<HockeyMatch> {
    public PossibleBetsHandicapBlock(MatchData homeMatchData, MatchData guestMatchData) {
        super(Arrays.asList(
            new PeriodTeamHandicapPossibleBetBlock(homeMatchData, guestMatchData)
        ), ContainerType.HANDICAP);
    }
}
