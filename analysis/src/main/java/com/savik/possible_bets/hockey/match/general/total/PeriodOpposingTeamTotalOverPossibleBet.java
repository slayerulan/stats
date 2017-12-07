package com.savik.possible_bets.hockey.match.general.total;


import com.savik.MatchData;
import com.savik.Period;
import com.savik.PeriodTeamBetContainer;
import com.savik.PossibleBet;
import com.savik.bets.general.total.over.PeriodGuestOver;
import com.savik.bets.general.total.over.PeriodHomeOver;
import com.savik.hockey.model.HockeyMatch;

import java.util.function.Function;

public class PeriodOpposingTeamTotalOverPossibleBet extends PossibleBet<HockeyMatch> {
    public PeriodOpposingTeamTotalOverPossibleBet(MatchData homeMatchData, MatchData guestMatchData,
                                                  Function<HockeyMatch, Period> function, double amount) {
        super(new PeriodTeamBetContainer<>(
                new PeriodGuestOver(amount),
                new PeriodHomeOver(amount),
                function, homeMatchData
        ), new PeriodTeamBetContainer<>(
                new PeriodHomeOver(amount),
                new PeriodGuestOver(amount),
                function, guestMatchData
        ));
    }
}
