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

    public void check(FootballMatch footballMatch) {
        if (leaf) {
            if (bet.canAnalyze(footballMatch)) {
                analyzedMatchesAmount++;
                boolean success = bet.check(footballMatch);
                if (success) {
                    successfullyMatchesAmount++;
                }
            } else {
                skippedMatchesAmount++;
            }
        } else {
            Consumer<BetContainer> checkMatch = betContainer -> betContainer.check(footballMatch);
            childrenBetBlocks.forEach(checkMatch);
        }
    }
}
