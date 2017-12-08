package com.savik.blocks.hockey.goals.match;

import com.savik.ContainerType;
import com.savik.GeneralTeamBetContainer;
import com.savik.Match;
import com.savik.MatchData;
import com.savik.bets.hockey.goals.GuestTotalOverInAllPeriods;
import com.savik.bets.hockey.goals.HomeTotalOverInAllPeriods;


public class TeamTotalOverInAllPeriodsBlock<T extends Match> extends GeneralTeamBetContainer<T> {

    public TeamTotalOverInAllPeriodsBlock(double total, ContainerType type) {
        super(
                new HomeTotalOverInAllPeriods(total),
                new GuestTotalOverInAllPeriods(total),
                type
        );
    }

    public TeamTotalOverInAllPeriodsBlock(double total, MatchData matchData) {
        super(
                new HomeTotalOverInAllPeriods(total),
                new GuestTotalOverInAllPeriods(total),
                matchData
        );
    }

}
