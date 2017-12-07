package com.savik.possible_bets.hockey.match.general.other;


import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.Period;
import com.savik.PossibleBetContainer;
import com.savik.hockey.model.HockeyMatch;

import java.util.function.Function;

class PeriodTeamWinAndTotalUnderPossibleBetBlock extends PossibleBetContainer<HockeyMatch> {
    public PeriodTeamWinAndTotalUnderPossibleBetBlock(MatchData homeMatchData, MatchData guestMatchData,
                                                      Function<HockeyMatch, Period> function, double amount, ContainerType type) {
        super(
                new PeriodTeamWinAndTotalUnderPossibleBet(homeMatchData, guestMatchData, function, amount), type
        );
    }
}
