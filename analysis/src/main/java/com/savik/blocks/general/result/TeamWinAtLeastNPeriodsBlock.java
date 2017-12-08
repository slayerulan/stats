package com.savik.blocks.general.result;

import com.savik.ContainerType;
import com.savik.GeneralTeamBetContainer;
import com.savik.Match;
import com.savik.MatchData;
import com.savik.bets.general.result.PeriodGuestWinner;
import com.savik.bets.general.result.PeriodHomeWinner;
import com.savik.bets.hockey.result.WinAtLeastNPeriods;


public class TeamWinAtLeastNPeriodsBlock<T extends Match> extends GeneralTeamBetContainer<T> {

    public TeamWinAtLeastNPeriodsBlock(int n, ContainerType type) {
        super(
                new WinAtLeastNPeriods(n, new PeriodHomeWinner()),
                new WinAtLeastNPeriods(n, new PeriodGuestWinner()),
                type
        );
    }

    public TeamWinAtLeastNPeriodsBlock(int n, MatchData matchData) {
        super(
                new WinAtLeastNPeriods(n, new PeriodHomeWinner()),
                new WinAtLeastNPeriods(n, new PeriodGuestWinner()),
                matchData
        );
    }

}
