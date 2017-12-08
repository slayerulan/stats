package com.savik.possible_bets.hockey.match.general.other;


import com.savik.MatchData;
import com.savik.PossibleBet;
import com.savik.blocks.hockey.goals.match.OpposingTeamTotalOverInAllPeriodsBlock;
import com.savik.blocks.hockey.goals.match.TeamTotalOverInAllPeriodsBlock;
import com.savik.hockey.model.HockeyMatch;

class PeriodOpposingTeamTotalOverInAllPeriodsPossibleBet extends PossibleBet<HockeyMatch> {
    public PeriodOpposingTeamTotalOverInAllPeriodsPossibleBet(MatchData homeMatchData, MatchData guestMatchData, double amount) {
        super(
                new OpposingTeamTotalOverInAllPeriodsBlock<>(amount, homeMatchData ),
                new TeamTotalOverInAllPeriodsBlock<>(amount, guestMatchData)
        );
    }
}
