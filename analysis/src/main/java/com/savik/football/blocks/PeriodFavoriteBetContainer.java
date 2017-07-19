package com.savik.football.blocks;

import java.util.List;
import java.util.function.Consumer;

import com.savik.football.bets.PeriodFavoriteBet;
import com.savik.football.model.FootballMatch;
import com.savik.football.model.Period;
import com.savik.football.model.Who;
import lombok.*;

@Getter
public abstract class PeriodFavoriteBetContainer extends BetContainer {

    private PeriodFavoriteBet bet;

    public PeriodFavoriteBetContainer(List<? extends BetContainer> childrenBetBlocks) {
        super(childrenBetBlocks);
    }

    public PeriodFavoriteBetContainer(PeriodFavoriteBet bet) {
        super();
        this.bet = bet;
    }

    public void check(FootballMatch footballMatch) {
        if (leaf) {
            Who favorite = footballMatch.getBookieStats().getFavorite();
            Period period = getPeriod(footballMatch);
            if (bet.canAnalyze(favorite, period)) {
                analyzedMatchesAmount++;
                boolean success = bet.check(favorite, period);
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
