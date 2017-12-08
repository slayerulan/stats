package com.savik.bets.hockey.other;


import com.savik.MatchData;
import com.savik.PossibleBet;
import com.savik.blocks.hockey.other.PeriodOpposingTeamFirstScoredAndWinSingleBlock;
import com.savik.blocks.hockey.other.PeriodTeamFirstScoredAndWinSingleBlock;
import com.savik.hockey.model.HockeyMatch;

public class OpposingTeamFirstScoredAndWinPossibleBet extends PossibleBet<HockeyMatch> {
    public OpposingTeamFirstScoredAndWinPossibleBet(MatchData homeMatchData, MatchData guestMatchData) {
        super(
                new PeriodOpposingTeamFirstScoredAndWinSingleBlock(homeMatchData),
                new PeriodTeamFirstScoredAndWinSingleBlock(guestMatchData)
        );
    }
}
