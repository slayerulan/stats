package com.savik.bets.general.other;


import com.savik.PossibleBet;
import com.savik.blocks.general.result.DrawAtLeastNPeriodsBlock;
import com.savik.hockey.model.HockeyMatch;

public class DrawAtLeastNPeriodsPossibleBet extends PossibleBet<HockeyMatch> {
    public DrawAtLeastNPeriodsPossibleBet(int n) {
        super(
                new DrawAtLeastNPeriodsBlock(n),
                new DrawAtLeastNPeriodsBlock(n)
        );
    }
}
