package com.savik.blocks.hockey.match.general.stats.penalties.match;


import com.savik.ContainerType;
import com.savik.PossibleBetContainer;
import com.savik.bets.hockey.stats.PenaltiesTimeTotalOverPossibleBet;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;

public class MinorPenaltiesTimeTotalOverPossibleBetBlock extends PossibleBetContainer<HockeyMatch> {
    public MinorPenaltiesTimeTotalOverPossibleBetBlock() {
        super(Arrays.asList(
                new PossibleBetContainer<>(
                        new PenaltiesTimeTotalOverPossibleBet(HockeyMatch.MATCH, 12.5),
                        ContainerType.OVER_12_5
                ),
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
                ),
                new PossibleBetContainer<>(
                        new PenaltiesTimeTotalOverPossibleBet(HockeyMatch.MATCH, 16.5),
                        ContainerType.OVER_16_5
                ),
                new PossibleBetContainer<>(
                        new PenaltiesTimeTotalOverPossibleBet(HockeyMatch.MATCH, 18.5),
                        ContainerType.OVER_18_5
                ),
                new PossibleBetContainer<>(
                        new PenaltiesTimeTotalOverPossibleBet(HockeyMatch.MATCH, 20.5),
                        ContainerType.OVER_20_5
                ),
                new PossibleBetContainer<>(
                        new PenaltiesTimeTotalOverPossibleBet(HockeyMatch.MATCH, 22.5),
                        ContainerType.OVER_22_5
                )
                ), ContainerType.MINOR_PENALTIES_TIME_OVER
        );
    }
}
