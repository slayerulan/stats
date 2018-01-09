package com.savik.blocks.hockey.match.general.stats.penalties.period;


import com.savik.ContainerType;
import com.savik.Period;
import com.savik.PossibleBetContainer;
import com.savik.bets.hockey.stats.PenaltiesTimeTotalOverPossibleBet;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;
import java.util.function.Function;

public class PeriodMinorPenaltiesTimeTotalOverPossibleBetBlock extends PossibleBetContainer<HockeyMatch> {
    public PeriodMinorPenaltiesTimeTotalOverPossibleBetBlock(Function<HockeyMatch, Period> period) {
        super(Arrays.asList(
                new PossibleBetContainer<>(
                        new PenaltiesTimeTotalOverPossibleBet(period, 2.5),
                        ContainerType.OVER_2_5
                ),
                new PossibleBetContainer<>(
                        new PenaltiesTimeTotalOverPossibleBet(period, 4.5),
                        ContainerType.OVER_4_5
                ),
                new PossibleBetContainer<>(
                        new PenaltiesTimeTotalOverPossibleBet(period, 6.5),
                        ContainerType.OVER_6_5
                )
                ), ContainerType.MINOR_PENALTIES_TIME_OVER
        );
    }
}
