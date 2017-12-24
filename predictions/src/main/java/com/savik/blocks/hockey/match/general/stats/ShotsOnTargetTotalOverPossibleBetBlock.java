package com.savik.blocks.hockey.match.general.stats;


import com.savik.ContainerType;
import com.savik.PossibleBetContainer;
import com.savik.bets.hockey.stats.ShotsOnTargetTotalOverPossibleBet;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;

public class ShotsOnTargetTotalOverPossibleBetBlock extends PossibleBetContainer<HockeyMatch> {
    public ShotsOnTargetTotalOverPossibleBetBlock() {
        super(Arrays.asList(
                new PossibleBetContainer<>(
                        new ShotsOnTargetTotalOverPossibleBet(HockeyMatch.MATCH, 57.5),
                        ContainerType.OVER_57_5
                ),
                new PossibleBetContainer<>(
                        new ShotsOnTargetTotalOverPossibleBet(HockeyMatch.MATCH, 58.5),
                        ContainerType.OVER_58_5
                ),
                new PossibleBetContainer<>(
                        new ShotsOnTargetTotalOverPossibleBet(HockeyMatch.MATCH, 59.5),
                        ContainerType.OVER_59_5
                ),
                new PossibleBetContainer<>(
                        new ShotsOnTargetTotalOverPossibleBet(HockeyMatch.MATCH, 60.5),
                        ContainerType.OVER_60_5
                ),
                new PossibleBetContainer<>(
                        new ShotsOnTargetTotalOverPossibleBet(HockeyMatch.MATCH, 61.5),
                        ContainerType.OVER_61_5
                ),
                new PossibleBetContainer<>(
                        new ShotsOnTargetTotalOverPossibleBet(HockeyMatch.MATCH, 62.5),
                        ContainerType.OVER_62_5
                ),
                new PossibleBetContainer<>(
                        new ShotsOnTargetTotalOverPossibleBet(HockeyMatch.MATCH, 63.5),
                        ContainerType.OVER_63_5
                )
                ), ContainerType.SHOTS_ON_TARGET_OVER
        );
    }
}
