package com.savik.possible_bets.hockey.match.general.handicap;


import com.savik.MatchData;
import com.savik.Period;
import com.savik.PossibleBet;
import com.savik.blocks.general.handicap.PeriodOpposingTeamHandicapSingleBlock;
import com.savik.blocks.general.handicap.PeriodTeamHandicapSingleBlock;
import com.savik.hockey.model.HockeyMatch;

import java.util.function.Function;

public class PeriodTeamHandicapPossibleBet extends PossibleBet<HockeyMatch> {
    public PeriodTeamHandicapPossibleBet(MatchData homeMatchData, MatchData guestMatchData,
                                         Function<HockeyMatch, Period> function, double amount) {
        super(
                new PeriodTeamHandicapSingleBlock<>(amount, function, homeMatchData),
                new PeriodOpposingTeamHandicapSingleBlock<>(amount, function, guestMatchData)
        );
    }
}
