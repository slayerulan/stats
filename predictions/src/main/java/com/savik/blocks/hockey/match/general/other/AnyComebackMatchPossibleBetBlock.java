package com.savik.blocks.hockey.match.general.other;


import com.savik.ContainerType;
import com.savik.PossibleBetContainer;
import com.savik.bets.general.other.PeriodAnyComebackPossibleBet;
import com.savik.hockey.model.HockeyMatch;

class AnyComebackMatchPossibleBetBlock extends PossibleBetContainer<HockeyMatch> {
    public AnyComebackMatchPossibleBetBlock() {
        super(
                new PeriodAnyComebackPossibleBet(HockeyMatch.MATCH),
                ContainerType.ANY_COMEBACK
        );
    }
}
