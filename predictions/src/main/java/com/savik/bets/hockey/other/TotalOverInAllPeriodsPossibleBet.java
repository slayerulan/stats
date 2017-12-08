package com.savik.bets.hockey.other;


import com.savik.PossibleBet;
import com.savik.blocks.hockey.goals.match.TotalOverInAllPeriodsSingleBlock;
import com.savik.hockey.model.HockeyMatch;

public class TotalOverInAllPeriodsPossibleBet extends PossibleBet<HockeyMatch> {
    public TotalOverInAllPeriodsPossibleBet(double amount) {
        super(
                new TotalOverInAllPeriodsSingleBlock(amount),
                new TotalOverInAllPeriodsSingleBlock(amount)
        );
    }
}
