package com.savik;

import com.savik.football.bets.GeneralBet;
import com.savik.football.model.FootballMatch;
import lombok.Getter;

import java.util.List;

@Getter
public abstract class GeneralBetContainer extends BetContainer<FootballMatch> {

    private GeneralBet bet;

    public GeneralBetContainer(List<? extends BetContainer> childrenBetBlocks) {
        super(childrenBetBlocks);
    }

    public GeneralBetContainer(GeneralBet bet) {
        super();
        this.bet = bet;
    }

    public GeneralBetContainer(GeneralBet bet, String type) {
        this(bet);
    }

    @Override
    public boolean canAnalyze(FootballMatch footballMatch) {
        return bet.canAnalyze(footballMatch);
    }

    @Override
    public boolean checkMatch(FootballMatch footballMatch) {
        return bet.check(footballMatch);
    }
}
