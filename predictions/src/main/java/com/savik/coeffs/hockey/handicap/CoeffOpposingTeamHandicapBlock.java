package com.savik.coeffs.hockey.handicap;


import com.savik.Coeff;
import com.savik.CoeffContainer;
import com.savik.ContainerType;

import java.util.Arrays;

public class CoeffOpposingTeamHandicapBlock extends CoeffContainer {
    public CoeffOpposingTeamHandicapBlock() {
        super(Arrays.asList(
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.MINUS_2_5
                ),
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.MINUS_1_5
                ),
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.PLUS_1_5
                ),
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.PLUS_2_5
                )
        ), ContainerType.OPPOSING_TEAM_HANDICAP);
    }
}
