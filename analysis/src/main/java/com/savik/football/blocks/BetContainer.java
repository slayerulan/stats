package com.savik.football.blocks;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.savik.football.model.FootballMatch;
import lombok.*;

@Getter
public abstract class BetContainer {

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

    public abstract void check(FootballMatch footballMatch);

}
