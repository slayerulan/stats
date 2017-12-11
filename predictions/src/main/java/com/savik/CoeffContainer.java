package com.savik;


import lombok.Getter;

import java.util.List;

@Getter
public class CoeffContainer {

    private ContainerType type;

    private List<? extends CoeffContainer> childrenBlocks;

    private Coeff coeff;

    private Boolean leaf;

    public CoeffContainer(List<? extends CoeffContainer> childrenBlocks, ContainerType type) {
        this.childrenBlocks = childrenBlocks;
        this.type = type;
        this.leaf = false;
    }

    public CoeffContainer(Coeff coeff, ContainerType type) {
        this.coeff = coeff;
        this.type = type;
        this.leaf = true;
    }
}
