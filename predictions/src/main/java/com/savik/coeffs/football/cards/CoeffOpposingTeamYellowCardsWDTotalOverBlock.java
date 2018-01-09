package com.savik.coeffs.football.cards;


import com.savik.Coeff;
import com.savik.CoeffContainer;
import com.savik.ContainerType;

import java.util.Arrays;

public class CoeffOpposingTeamYellowCardsWDTotalOverBlock extends CoeffContainer {
    public CoeffOpposingTeamYellowCardsWDTotalOverBlock() {
        super(Arrays.asList(
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.OVER_1_5
                ),
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.OVER_2_5
                ),
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.OVER_3_5
                ),
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.OVER_4_5
                )
        ), ContainerType.OPPOSING_TEAM_TOTAL_OVER);
    }
}