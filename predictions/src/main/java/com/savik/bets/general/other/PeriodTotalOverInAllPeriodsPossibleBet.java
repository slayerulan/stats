package com.savik.bets.general.other;


import com.savik.PossibleBet;
import com.savik.blocks.hockey.goals.match.TotalOverInAllPeriodsSingleBlock;
import com.savik.hockey.model.HockeyMatch;

public class PeriodTotalOverInAllPeriodsPossibleBet extends PossibleBet<HockeyMatch> {
    public PeriodTotalOverInAllPeriodsPossibleBet(double amount) {
        super(
                new TotalOverInAllPeriodsSingleBlock(amount),
                new TotalOverInAllPeriodsSingleBlock(amount)
        );
    }
}
