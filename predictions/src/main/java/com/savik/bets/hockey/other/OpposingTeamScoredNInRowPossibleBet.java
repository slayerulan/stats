package com.savik.bets.hockey.other;


import com.savik.MatchData;
import com.savik.PossibleBet;
import com.savik.blocks.hockey.other.PeriodOpposingTeamScoredNInRowSingleBlock;
import com.savik.blocks.hockey.other.PeriodTeamScoredNInRowSingleBlock;
import com.savik.hockey.model.HockeyMatch;

public class OpposingTeamScoredNInRowPossibleBet extends PossibleBet<HockeyMatch> {
    public OpposingTeamScoredNInRowPossibleBet(int n, MatchData homeMatchData, MatchData guestMatchData) {
        super(
                new PeriodOpposingTeamScoredNInRowSingleBlock(n, homeMatchData),
                new PeriodTeamScoredNInRowSingleBlock(n, guestMatchData)
        );
    }
}
