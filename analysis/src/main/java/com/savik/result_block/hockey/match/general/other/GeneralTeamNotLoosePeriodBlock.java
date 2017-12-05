package com.savik.result_block.hockey.match.general.other;

import com.savik.*;
import com.savik.bets.general.result.PeriodAnyWinner;
import com.savik.bets.general.result.PeriodGuestNotLoose;
import com.savik.bets.general.result.PeriodHomeNotLoose;
import com.savik.hockey.model.HockeyMatch;

import java.util.function.Function;

import static com.savik.ContainerType.TEAM_NOT_LOOSE_FIRST_PERIOD;


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
