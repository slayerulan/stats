package com.savik.coeffs.football.cards;


import com.savik.CoeffContainer;
import com.savik.ContainerType;

import java.util.Arrays;

public class CoeffCardsBlock extends CoeffContainer {
    public CoeffCardsBlock() {
        super(Arrays.asList(
                new CoeffYellowCardsWDTotalOverBlock(),
                new CoeffYellowCardsWDTotalUnderBlock(),
                new CoeffTeamYellowCardsWDTotalOverBlock(),
                new CoeffOpposingTeamYellowCardsWDTotalOverBlock(),
                new CoeffTeamYellowCardsWDNotLooseBlock(),
                new CoeffOpposingTeamYellowCardsWDNotLooseBlock(),
                new CoeffTeamYellowCardsWDHandicapBlock(),
                new CoeffOpposingTeamYellowCardsWDHandicapBlock()
        ), ContainerType.CORNERS);
    }
}
