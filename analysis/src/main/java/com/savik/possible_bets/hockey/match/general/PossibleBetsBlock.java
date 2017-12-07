package com.savik.possible_bets.hockey.match.general;


import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.PossibleBetContainer;
import com.savik.hockey.model.HockeyMatch;
import com.savik.possible_bets.hockey.match.general.handicap.PossibleBetsHandicapBlock;
import com.savik.possible_bets.hockey.match.general.other.PossibleBetsOtherBlock;
import com.savik.possible_bets.hockey.match.general.total.PossibleBetsTotalBlock;

import java.util.Arrays;

public class PossibleBetsBlock extends PossibleBetContainer<HockeyMatch> {
    public PossibleBetsBlock(MatchData homeMatchData, MatchData guestMatchData) {
        super(Arrays.asList(
                new PossibleBetsTotalBlock(homeMatchData, guestMatchData),
                new PossibleBetsOtherBlock(homeMatchData, guestMatchData),
                new PossibleBetsHandicapBlock(homeMatchData, guestMatchData)
        ), ContainerType.ROOT);
    }
}
