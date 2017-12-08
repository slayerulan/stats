package com.savik.bets.hockey.other;


import com.savik.PossibleBet;
import com.savik.blocks.hockey.goals.match.TotalUnderInAllPeriodsSingleBlock;
import com.savik.hockey.model.HockeyMatch;

public class TotalUnderInAllPeriodsPossibleBet extends PossibleBet<HockeyMatch> {
    public TotalUnderInAllPeriodsPossibleBet(double amount) {
        super(
                new TotalUnderInAllPeriodsSingleBlock(amount),
                new TotalUnderInAllPeriodsSingleBlock(amount)
        );
    }
}
