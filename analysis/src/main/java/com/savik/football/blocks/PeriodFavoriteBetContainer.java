package com.savik.football.blocks;

import java.util.List;

import com.savik.football.bets.PeriodFavoriteBet;
import com.savik.football.model.FootballMatch;
import com.savik.football.model.Period;
import com.savik.football.model.Who;
import lombok.*;

@Getter
public abstract class PeriodFavoriteBetContainer {

    private List<PeriodFavoriteBetContainer> childrenBetBlocks;

    private PeriodFavoriteBet bet;

    private Boolean leaf;

    private Integer analyzedMatchesAmount;

    private Integer skippedMatchesAmount;

    private Integer successfullyMatchesAmount;

    public PeriodFavoriteBetContainer(List<PeriodFavoriteBetContainer> childrenBetBlocks) {
        this.childrenBetBlocks = childrenBetBlocks;
        this.leaf = false;
    }

    public PeriodFavoriteBetContainer(PeriodFavoriteBet bet) {
        this.bet = bet;
        this.leaf = true;
        this.analyzedMatchesAmount = 0;
        this.skippedMatchesAmount = 0;
        this.successfullyMatchesAmount = 0;
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
            childrenBetBlocks.forEach(b -> b.check(footballMatch));
        }
    }

    public abstract Period getPeriod(FootballMatch footballMatch);
}
