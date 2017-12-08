package com.savik.bets.hockey.other;


import com.savik.MatchData;
import com.savik.PossibleBet;
import com.savik.blocks.hockey.other.PeriodOpposingTeamFirstScoredAndWinSingleBlock;
import com.savik.blocks.hockey.other.PeriodTeamFirstScoredAndWinSingleBlock;
import com.savik.hockey.model.HockeyMatch;

public class TeamFirstScoredAndWinPossibleBet extends PossibleBet<HockeyMatch> {
    public TeamFirstScoredAndWinPossibleBet(MatchData homeMatchData, MatchData guestMatchData) {
        super(
                new PeriodTeamFirstScoredAndWinSingleBlock(homeMatchData),
                new PeriodOpposingTeamFirstScoredAndWinSingleBlock(guestMatchData)
        );
    }
}
