package com.savik.result_block.hockey.match.general.periods;

import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.Period;
import com.savik.PeriodTeamBetContainer;
import com.savik.bets.general.result.PeriodGuestNotLoose;
import com.savik.bets.general.result.PeriodHomeNotLoose;
import com.savik.hockey.model.HockeyMatch;

import java.util.function.Function;


class GeneralTeamNotLoosePeriodBlock extends PeriodTeamBetContainer {

    public GeneralTeamNotLoosePeriodBlock(MatchData matchData, Function<HockeyMatch, Period> function, ContainerType type) {
        super(
                new PeriodHomeNotLoose(),
                new PeriodGuestNotLoose(),
                type,
                function,
                matchData
        );
    }
}
