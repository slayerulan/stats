package com.savik.possible_bets.hockey.match.general.other;


import com.savik.PossibleBet;
import com.savik.blocks.hockey.goals.match.TotalOverInAllPeriodsSingleBlock;
import com.savik.hockey.model.HockeyMatch;

class PeriodTotalOverInAllPeriodsPossibleBet extends PossibleBet<HockeyMatch> {
    public PeriodTotalOverInAllPeriodsPossibleBet(double amount) {
        super(
                new TotalOverInAllPeriodsSingleBlock(amount),
                new TotalOverInAllPeriodsSingleBlock(amount)
        );
    }
}
