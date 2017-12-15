package com.savik.blocks.hockey.match.general.stats;


import com.savik.ContainerType;
import com.savik.PossibleBetContainer;
import com.savik.bets.hockey.stats.PenaltiesTimeTotalOverPossibleBet;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;

public class PenaltiesTimeTotalOverPossibleBetBlock extends PossibleBetContainer<HockeyMatch> {
    public PenaltiesTimeTotalOverPossibleBetBlock() {
        super(Arrays.asList(
                new PossibleBetContainer<>(
                        new PenaltiesTimeTotalOverPossibleBet(HockeyMatch.MATCH, 13.5),
                        ContainerType.OVER_13_5
                ),
                new PossibleBetContainer<>(
                        new PenaltiesTimeTotalOverPossibleBet(HockeyMatch.MATCH, 14.5),
                        ContainerType.OVER_14_5
                ),
                new PossibleBetContainer<>(
                        new PenaltiesTimeTotalOverPossibleBet(HockeyMatch.MATCH, 15.5),
                        ContainerType.OVER_15_5
                )
                ), ContainerType.PENALTIES_TIME_OVER
        );
    }
}