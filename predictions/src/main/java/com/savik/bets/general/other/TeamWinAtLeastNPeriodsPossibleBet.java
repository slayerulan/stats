package com.savik.bets.general.other;


import com.savik.Match;
import com.savik.MatchData;
import com.savik.PossibleBet;
import com.savik.blocks.general.result.OpposingTeamWinAtLeastNPeriodsBlock;
import com.savik.blocks.general.result.TeamWinAtLeastNPeriodsBlock;

public class TeamWinAtLeastNPeriodsPossibleBet<T extends Match> extends PossibleBet<T> {
    public TeamWinAtLeastNPeriodsPossibleBet(MatchData homeMatchData, MatchData guestMatchData, int n) {
        super(
                new TeamWinAtLeastNPeriodsBlock<T>(n, homeMatchData),
                new OpposingTeamWinAtLeastNPeriodsBlock<T>(n, guestMatchData)
        );
    }
}
