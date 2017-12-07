package com.savik.possible_bets.hockey.match.general.total;


import com.savik.MatchData;
import com.savik.Period;
import com.savik.PeriodTeamBetContainer;
import com.savik.PossibleBet;
import com.savik.bets.general.total.under.PeriodGuestUnder;
import com.savik.bets.general.total.under.PeriodHomeUnder;
import com.savik.hockey.model.HockeyMatch;

import java.util.function.Function;

public class PeriodTeamTotalUnderPossibleBet extends PossibleBet<HockeyMatch> {
    public PeriodTeamTotalUnderPossibleBet(MatchData homeMatchData, MatchData guestMatchData,
                                           Function<HockeyMatch, Period> function, double amount) {
        super(new PeriodTeamBetContainer<>(
                new PeriodHomeUnder(amount),
                new PeriodGuestUnder(amount),
                function, homeMatchData
        ), new PeriodTeamBetContainer<>(
                new PeriodGuestUnder(amount),
                new PeriodHomeUnder(amount),
                function, guestMatchData
        ));
    }
}
