package com.savik.coeffs.football;


import com.savik.CoeffContainer;
import com.savik.ContainerType;
import com.savik.coeffs.football.cards.CoeffCardsBlock;
import com.savik.coeffs.football.corners.CoeffCornersBlock;

import java.util.Arrays;

public class FootballCoeffBlock extends CoeffContainer {
    public FootballCoeffBlock() {
        super(Arrays.asList(
                new CoeffCornersBlock(),
                new CoeffCardsBlock()
        ), ContainerType.ROOT);
    }
}
