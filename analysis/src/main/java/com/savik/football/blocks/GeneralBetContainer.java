package com.savik.football.blocks;

import java.util.List;
import java.util.function.Consumer;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.savik.football.bets.GeneralBet;
import com.savik.football.model.FootballMatch;
import lombok.*;

@Getter
public abstract class GeneralBetContainer extends BetContainer {

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
