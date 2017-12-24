package com.savik.bets.hockey.other;


import com.savik.MatchData;
import com.savik.PossibleBet;
import com.savik.blocks.hockey.other.PeriodOpposingTeamScoredNInRowSingleBlock;
import com.savik.blocks.hockey.other.PeriodTeamScoredNInRowSingleBlock;
import com.savik.hockey.model.HockeyMatch;

public class TeamScoredNInRowPossibleBet extends PossibleBet<HockeyMatch> {
    public TeamScoredNInRowPossibleBet(int n, MatchData homeMatchData, MatchData guestMatchData) {
        super(
                new PeriodTeamScoredNInRowSingleBlock(n, homeMatchData),
                new PeriodOpposingTeamScoredNInRowSingleBlock(n, guestMatchData)
        );
    }
}
