package com.savik.bets.hockey.other;


import com.savik.PossibleBet;
import com.savik.blocks.hockey.goals.match.MostEffectivePeriodTotalOverSingleBlock;
import com.savik.hockey.model.HockeyMatch;

public class LessEffectivePeriodTotalOverPossibleBet extends PossibleBet<HockeyMatch> {
    public LessEffectivePeriodTotalOverPossibleBet(double total) {
        super(
                new MostEffectivePeriodTotalOverSingleBlock(total),
                new MostEffectivePeriodTotalOverSingleBlock(total)
        );
    }
}
