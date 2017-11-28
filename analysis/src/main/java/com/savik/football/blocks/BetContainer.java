package com.savik.football.blocks;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.savik.Match;
import lombok.Getter;

import java.util.List;
import java.util.function.Consumer;

@Getter
public abstract class BetContainer<T extends Match> {

    protected List<? extends BetContainer> childrenBetBlocks;

    protected Boolean leaf;

    protected Integer analyzedMatchesAmount;

    protected Integer skippedMatchesAmount;

    protected Integer successfullyMatchesAmount;

    @JsonProperty("percentage")
    public Integer getPercentage() {
        if (!leaf || analyzedMatchesAmount == 0) {
            return null;
        }
        return (successfullyMatchesAmount * 100) / analyzedMatchesAmount;
    }

    public BetContainer(List<? extends BetContainer> childrenBetBlocks) {
        this.childrenBetBlocks = childrenBetBlocks;
        this.leaf = false;
    }

    public BetContainer() {
        this.leaf = true;
        this.analyzedMatchesAmount = 0;
        this.skippedMatchesAmount = 0;
        this.successfullyMatchesAmount = 0;
    }

    public void check(T match) {
        if (leaf) {
            if (canAnalyze(match)) {
                analyzedMatchesAmount++;
                boolean success = checkMatch(match);
                if (success) {
                    successfullyMatchesAmount++;
                }
            } else {
                skippedMatchesAmount++;
            }
        } else {
            Consumer<BetContainer> checkMatch = betContainer -> betContainer.check(match);
            childrenBetBlocks.forEach(checkMatch);
        }
    }

    protected abstract boolean canAnalyze(T match);

    protected abstract boolean checkMatch(T match);

}
