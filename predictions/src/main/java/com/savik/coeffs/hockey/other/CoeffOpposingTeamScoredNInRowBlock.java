package com.savik.coeffs.hockey.other;


import com.savik.Coeff;
import com.savik.CoeffContainer;
import com.savik.ContainerType;

import java.util.Arrays;

public class CoeffOpposingTeamScoredNInRowBlock extends CoeffContainer {
    public CoeffOpposingTeamScoredNInRowBlock() {
        super(Arrays.asList(
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.NUMBER_2
                ),
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.NUMBER_3
                )
        ), ContainerType.OPPOSING_TEAM_SCORED_N_IN_ROW);
    }
}