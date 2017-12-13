package com.savik;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class PossibleBetContainer<T extends Match> {

    private List<? extends PossibleBetContainer<T>> childrenBetBlocks;

    private PossibleBet<T> possibleBet;

    private ContainerType type;

    private Boolean leaf;

    public PossibleBetContainer(List<? extends PossibleBetContainer<T>> childrenBetBlocks, ContainerType type) {
        this.childrenBetBlocks = childrenBetBlocks;
        this.type = type;
        this.leaf = false;
    }

    public PossibleBetContainer(PossibleBet<T> possibleBet, ContainerType type) {
        this.possibleBet = possibleBet;
        this.type = type;
        this.leaf = true;
    }

    public PossibleBetContainer(PossibleBet<T> possibleBet) {
        this(possibleBet, null);
    }

    public int getFirstTeamPercentage() {
        return possibleBet.getFirstTeamPercentage();
    }

    public int getSecondTeamPercentage() {
        return possibleBet.getSecondTeamPercentage();
    }


    public void check(List<T> firstTeamMatches, List<T> secondTeamMatches) {
        if (leaf) {
            possibleBet.check(firstTeamMatches, secondTeamMatches);
        } else {
            for (int i = 0; i < childrenBetBlocks.size(); i++) {
                PossibleBetContainer<T> possibleBetContainer = childrenBetBlocks.get(i);
                possibleBetContainer.check(firstTeamMatches, secondTeamMatches);
            }
        }

    }

    public PossibleBetContainer<T> findByType(ContainerType type) {
        if(this.type == type) {
            return this;
        }
        if(!leaf) {
            for (PossibleBetContainer childBlock : childrenBetBlocks) {
                PossibleBetContainer byType = childBlock.findByType(type);
                if (byType != null) {
                    return byType;
                }
            }
        }
        return null;
    }
}
