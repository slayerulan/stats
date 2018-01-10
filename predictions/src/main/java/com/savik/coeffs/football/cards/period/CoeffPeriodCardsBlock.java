package com.savik.coeffs.football.cards.period;


import com.savik.CoeffContainer;
import com.savik.ContainerType;

import java.util.Arrays;

public class CoeffPeriodCardsBlock extends CoeffContainer {
    public CoeffPeriodCardsBlock(ContainerType containerType) {
        super(Arrays.asList(
                new CoeffYellowCardsWDTotalOverBlock(),
                new CoeffYellowCardsWDTotalUnderBlock(),
                new CoeffTeamYellowCardsWDTotalOverBlock(),
                new CoeffOpposingTeamYellowCardsWDTotalOverBlock(),
                new CoeffTeamYellowCardsWDNotLooseBlock(),
                new CoeffOpposingTeamYellowCardsWDNotLooseBlock(),
                new CoeffTeamYellowCardsWDHandicapBlock(),
                new CoeffOpposingTeamYellowCardsWDHandicapBlock()
        ), containerType);
    }
}
