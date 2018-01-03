package com.savik;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class ProposedBetsContainer {

    private List<ProposedBetsContainer> childrenBlocks;

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


    public ProposedBetsContainer(List<ProposedBetsContainer> childrenBlocks, ContainerType type) {
        this.childrenBlocks = childrenBlocks;
        this.type = type;
        this.leaf = false;
    }

    public ProposedBetsContainer(ContainerType type) {
        this.type = type;
        this.leaf = true;
    }
}
