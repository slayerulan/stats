package com.savik.result_block.hockey.match.general.periods;

import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.Period;
import com.savik.PeriodTeamBetContainer;
import com.savik.bets.general.total.over.PeriodGuestOver;
import com.savik.bets.general.total.over.PeriodHomeOver;
import com.savik.blocks.general.total.over.PeriodTeamTotalOverBlock;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;
import java.util.function.Function;

import static com.savik.ContainerType.OVER_0_5;
import static com.savik.ContainerType.OVER_1_5;


class GeneralTeamTotalOverPeriodBlock extends PeriodTeamBetContainer {

    public GeneralTeamTotalOverPeriodBlock(MatchData matchData, Function<HockeyMatch, Period> function, ContainerType type) {
        super(
                Arrays.asList(
                        new PeriodTeamTotalOverBlock(0.5, OVER_0_5),
                        new PeriodTeamTotalOverBlock(1.5, OVER_1_5)
                ),
                function,
                matchData,
                type
        );
    }
}
