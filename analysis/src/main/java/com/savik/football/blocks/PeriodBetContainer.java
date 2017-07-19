package com.savik.football.blocks;

import java.util.List;
import java.util.function.Consumer;

import com.savik.football.bets.PeriodBet;
import com.savik.football.model.FootballMatch;
import com.savik.football.model.Period;
import lombok.*;

@Getter
public abstract class PeriodBetContainer extends BetContainer {

    private PeriodBet bet;

    public PeriodBetContainer(List<? extends BetContainer> childrenBetBlocks) {
        super(childrenBetBlocks);
    }

    public PeriodBetContainer(PeriodBet bet) {
        super();
        this.bet = bet;
    }


    public void check(FootballMatch footballMatch) {
        if (leaf) {
            Period period = getPeriod(footballMatch);
            if (bet.canAnalyze(period)) {
                analyzedMatchesAmount++;
                boolean success = bet.check(period);
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

    public abstract Period getPeriod(FootballMatch footballMatch);
}
