package com.savik;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

@Getter
public abstract class BetContainer<T extends Match> {

    protected List<? extends BetContainer> childrenBetBlocks;

    protected Boolean leaf;

    protected ContainerType type;

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

    public BetContainer(List<? extends BetContainer> childrenBetBlocks, ContainerType type) {
        this(childrenBetBlocks);
        this.type = type;
    }

    public BetContainer(List<? extends BetContainer> childrenBetBlocks) {
        this.childrenBetBlocks = childrenBetBlocks;
        this.leaf = false;
    }

    public BetContainer(BetContainer childBetBlock) {
        this(Arrays.asList(childBetBlock));
    }

    public BetContainer(ContainerType type) {
        this();
        this.type = type;
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

    public BetContainer<T> findByType(ContainerType type) {
        if(this.type == type) {
            return this;
        }
        if(!leaf) {
            for (BetContainer childBlock : childrenBetBlocks) {
                BetContainer byType = childBlock.findByType(type);
                if (byType != null) {
                    return byType;
                }
            }
        }
        return null;
    }

    protected abstract boolean canAnalyze(T match);

    protected abstract boolean checkMatch(T match);

}
