package com.savik.possible_bets.hockey.match.general.other;


import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.Period;
import com.savik.PossibleBetContainer;
import com.savik.hockey.model.HockeyMatch;

import java.util.function.Function;

class PeriodTeamWinAndTotalOverPossibleBetBlock extends PossibleBetContainer<HockeyMatch> {
    public PeriodTeamWinAndTotalOverPossibleBetBlock(MatchData homeMatchData, MatchData guestMatchData,
                                                     Function<HockeyMatch, Period> function, double amount, ContainerType type) {
        super(
                new PeriodTeamWinAndTotalOverPossibleBet(homeMatchData, guestMatchData, function, amount), type
        );
    }
}
