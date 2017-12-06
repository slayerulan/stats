package com.savik.possible_bets.hockey.match.general.total;


import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.Period;
import com.savik.PossibleBetContainer;
import com.savik.hockey.model.HockeyMatch;

import java.util.function.Function;

public class PeriodTeamTotalOverPossibleBetBlock extends PossibleBetContainer<HockeyMatch> {
    public PeriodTeamTotalOverPossibleBetBlock(MatchData homeMatchData, MatchData guestMatchData,
                                               Function<HockeyMatch, Period> function, double amount, ContainerType type) {
        super(
                new PeriodTeamTotalOverPossibleBet(homeMatchData, guestMatchData, function, amount), type
        );
    }
}
