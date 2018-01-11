package com.savik.coeffs.football.cards;


import com.savik.CoeffContainer;
import com.savik.ContainerType;
import com.savik.coeffs.football.cards.period.*;

import java.util.Arrays;

public class CoeffCardsBlock extends CoeffContainer {
    public CoeffCardsBlock() {
        super(Arrays.asList(
                new CoeffPeriodCardsBlock(ContainerType.MATCH),
                new CoeffPeriodCardsBlock(ContainerType.FIRST_PERIOD),
                new CoeffPeriodCardsBlock(ContainerType.SECOND_PERIOD)
        ), ContainerType.CARDS);
    }
}
