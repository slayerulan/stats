package com.savik.bets.general.other;


import com.savik.Match;
import com.savik.MatchData;
import com.savik.PossibleBet;
import com.savik.blocks.hockey.goals.match.OpposingTeamTotalOverInAllPeriodsBlock;
import com.savik.blocks.hockey.goals.match.TeamTotalOverInAllPeriodsBlock;

public class PeriodOpposingTeamTotalOverInAllPeriodsPossibleBet<T extends Match> extends PossibleBet<T> {
    public PeriodOpposingTeamTotalOverInAllPeriodsPossibleBet(MatchData homeMatchData, MatchData guestMatchData, double amount) {
        super(
                new OpposingTeamTotalOverInAllPeriodsBlock<>(amount, homeMatchData ),
                new TeamTotalOverInAllPeriodsBlock<>(amount, guestMatchData)
        );
    }
}
