package com.savik.bets.general.other;


import com.savik.Match;
import com.savik.MatchData;
import com.savik.PossibleBet;
import com.savik.blocks.general.result.OpposingTeamWinAtLeastNPeriodsBlock;
import com.savik.blocks.general.result.TeamWinAtLeastNPeriodsBlock;

public class OpposingTeamWinAtLeastNPeriodsPossibleBet<T extends Match> extends PossibleBet<T> {
    public OpposingTeamWinAtLeastNPeriodsPossibleBet(MatchData homeMatchData, MatchData guestMatchData, int n) {
        super(
                new OpposingTeamWinAtLeastNPeriodsBlock<T>(n, homeMatchData),
                new TeamWinAtLeastNPeriodsBlock<T>(n, guestMatchData)
        );
    }
}
