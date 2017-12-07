package com.savik.possible_bets.hockey.match.general.other;


import com.savik.MatchData;
import com.savik.Period;
import com.savik.PeriodTeamBetContainer;
import com.savik.PossibleBet;
import com.savik.bets.general.total.over.PeriodGuestOver;
import com.savik.bets.general.total.over.PeriodHomeOver;
import com.savik.blocks.general.result.PeriodAnyWinAndDiffEqualsBlock;
import com.savik.hockey.model.HockeyMatch;

import java.util.function.Function;

import static com.savik.ContainerType.DIFF_1;

class PeriodAnyWinAndDiffEqualsPossibleBet extends PossibleBet<HockeyMatch> {
    public PeriodAnyWinAndDiffEqualsPossibleBet(Function<HockeyMatch, Period> function, int diff) {
        super(
                new PeriodAnyWinAndDiffEqualsBlock<>(diff, function),
                new PeriodAnyWinAndDiffEqualsBlock<>(diff, function)
        );
    }
}
