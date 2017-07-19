package com.savik.football.blocks;

import java.util.List;

import com.savik.football.bets.PeriodBet;
import com.savik.football.model.FootballMatch;
import com.savik.football.model.Period;
import lombok.*;

@Getter
public abstract class PeriodBetContainer {

    private List<PeriodBetContainer> childrenBetBlocks;

    private PeriodBet bet;

    private Boolean leaf;

    private Integer analyzedMatchesAmount;

    private Integer skippedMatchesAmount;

    private Integer successfullyMatchesAmount;

    public PeriodBetContainer(List<PeriodBetContainer> childrenBetBlocks) {
        this.childrenBetBlocks = childrenBetBlocks;
        this.leaf = false;
    }

    public PeriodBetContainer(PeriodBet bet) {
        this.bet = bet;
        this.leaf = true;
        this.analyzedMatchesAmount = 0;
        this.skippedMatchesAmount = 0;
        this.successfullyMatchesAmount = 0;
    }

    public void check(FootballMatch footballMatch) {
        if (leaf) {
            if (bet.canAnalyze(getPeriod(footballMatch))) {
                analyzedMatchesAmount++;
                boolean success = bet.check(getPeriod(footballMatch));
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
