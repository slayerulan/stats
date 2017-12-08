package com.savik.blocks.hockey.goals.match;

import com.savik.ContainerType;
import com.savik.GeneralTeamBetContainer;
import com.savik.Match;
import com.savik.MatchData;
import com.savik.bets.hockey.goals.match.GuestTotalOverInAllPeriods;
import com.savik.bets.hockey.goals.match.HomeTotalOverInAllPeriods;


public class OpposingTeamTotalOverInAllPeriodsBlock<T extends Match> extends GeneralTeamBetContainer<T> {

    public OpposingTeamTotalOverInAllPeriodsBlock(double total, ContainerType type) {
        super(
                new GuestTotalOverInAllPeriods(total),
                new HomeTotalOverInAllPeriods(total),
                type
        );
    }

    public OpposingTeamTotalOverInAllPeriodsBlock(double total, MatchData matchData) {
        super(
                new GuestTotalOverInAllPeriods(total),
                new HomeTotalOverInAllPeriods(total),
                matchData
        );
    }

}
