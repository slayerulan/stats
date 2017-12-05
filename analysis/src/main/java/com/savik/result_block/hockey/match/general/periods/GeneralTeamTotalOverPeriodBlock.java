package com.savik.result_block.hockey.match.general.periods;

import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.Period;
import com.savik.PeriodTeamBetContainer;
import com.savik.bets.general.total.over.PeriodGuestOver;
import com.savik.bets.general.total.over.PeriodHomeOver;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;
import java.util.function.Function;


class GeneralTeamTotalOverPeriodBlock extends PeriodTeamBetContainer {

    public GeneralTeamTotalOverPeriodBlock(MatchData matchData, Function<HockeyMatch, Period> function, ContainerType type) {
        super(
                Arrays.asList(
                        new PeriodTeamBetContainer(
                                new PeriodHomeOver(0.5),
                                new PeriodGuestOver(0.5),
                                ContainerType.OVER_0_5
                        ),
                        new PeriodTeamBetContainer(
                                new PeriodHomeOver(1.5),
                                new PeriodGuestOver(1.5),
                                ContainerType.OVER_1_5
                        )
                ),
                function,
                matchData,
                type
        );
    }
}
