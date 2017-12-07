package com.savik.possible_bets.hockey.match.general.other;


import com.savik.MatchData;
import com.savik.PossibleBet;
import com.savik.blocks.hockey.goals.match.OpposingTeamTotalOverInAllPeriodsBlock;
import com.savik.blocks.hockey.goals.match.TeamTotalOverInAllPeriodsBlock;
import com.savik.hockey.model.HockeyMatch;

class PeriodTeamTotalOverInAllPeriodsPossibleBet extends PossibleBet<HockeyMatch> {
    public PeriodTeamTotalOverInAllPeriodsPossibleBet(MatchData homeMatchData, MatchData guestMatchData, double amount) {
        super(
                new TeamTotalOverInAllPeriodsBlock<>(amount, homeMatchData),
                new OpposingTeamTotalOverInAllPeriodsBlock<>(amount, guestMatchData)
        );
    }
}
