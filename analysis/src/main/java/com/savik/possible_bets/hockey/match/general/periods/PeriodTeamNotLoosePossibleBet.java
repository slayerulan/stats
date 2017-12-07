package com.savik.possible_bets.hockey.match.general.periods;


import com.savik.MatchData;
import com.savik.Period;
import com.savik.PossibleBet;
import com.savik.blocks.general.result.PeriodOpposingTeamNotLooseBlock;
import com.savik.blocks.general.result.PeriodTeamNotLooseBlock;
import com.savik.hockey.model.HockeyMatch;

import java.util.function.Function;

public class PeriodTeamNotLoosePossibleBet extends PossibleBet<HockeyMatch> {
    public PeriodTeamNotLoosePossibleBet(MatchData homeMatchData, MatchData guestMatchData,
                                         Function<HockeyMatch, Period> function) {
        super(
                new PeriodTeamNotLooseBlock<>(homeMatchData, function),
                new PeriodOpposingTeamNotLooseBlock<>(guestMatchData, function)
        );
    }
}
