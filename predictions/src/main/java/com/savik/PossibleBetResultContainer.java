package com.savik;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class PossibleBetResultContainer {

    private List<PossibleBetResultContainer> childrenBlocks;

    private ContainerType type;

    private Boolean leaf;

    private Coeff coeff;

    private BetContainer firstTeamContainer;

    private BetContainer secondTeamContainer;

    private PossibleBetStatus possibleBetStatus;

    private CoeffType coeffType;

    private double valueBet;

    private Double firstTeamPercentage;

    private Double secondTeamPercentage;


    public PossibleBetResultContainer(List<PossibleBetResultContainer> childrenBlocks, ContainerType type) {
        this.childrenBlocks = childrenBlocks;
        this.type = type;
        this.leaf = false;
    }

    public PossibleBetResultContainer(ContainerType type) {
        this.type = type;
        this.leaf = true;
    }
}
