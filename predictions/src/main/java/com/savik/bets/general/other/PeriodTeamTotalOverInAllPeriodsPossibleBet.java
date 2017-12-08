package com.savik.bets.general.other;


import com.savik.Match;
import com.savik.MatchData;
import com.savik.PossibleBet;
import com.savik.blocks.hockey.goals.match.OpposingTeamTotalOverInAllPeriodsBlock;
import com.savik.blocks.hockey.goals.match.TeamTotalOverInAllPeriodsBlock;

public class PeriodTeamTotalOverInAllPeriodsPossibleBet<T extends Match> extends PossibleBet<T> {
    public PeriodTeamTotalOverInAllPeriodsPossibleBet(MatchData homeMatchData, MatchData guestMatchData, double amount) {
        super(
                new TeamTotalOverInAllPeriodsBlock<>(amount, homeMatchData),
                new OpposingTeamTotalOverInAllPeriodsBlock<>(amount, guestMatchData)
        );
    }
}
